#!/usr/bin/python
#
# Uses long and double versions of classes as templates to create 
# versions for other Java primitive types.
#
# Example usage:
#     python scripts/copy_primitive_classes.py
#

import sys
import re
import os

class TypeDef:
    
    def __init__(self, name, prim, const, is_integral):
        self.name = name
        self.prim = prim
        self.const = const
        self.is_integral = is_integral
        
def get_typedef_repls(src, dest):
    return [(src.name, dest.name),
            (src.prim, dest.prim),
            (src.const, dest.const)]
    
def get_typedefs():
    return {"byte" : TypeDef("Byte", "byte", "BYTE", True),
            "short" : TypeDef("Short", "short", "SHORT", True),
            "int" : TypeDef("Int", "int", "INT", True),
            "long" : TypeDef("Long", "long", "LONG", True),
            "float" : TypeDef("Float", "float", "FLOAT", False),
            "double" : TypeDef("Double", "double", "DOUBLE", False),
            "none" : TypeDef("", "", "", False),
        }
        
def file_to_str(filename):
    # Read the string from a file.
    f = open(filename, 'r')
    s = ""
    for line in f:
        s = s + line
    return s
    
def str_to_file(s, filename):
    # Write the new string to that file
    if not os.path.exists(os.path.dirname(filename)):
        os.makedirs(os.path.dirname(filename))
    f = open(filename, 'w')
    f.write(s)
    f.close()
    
def replace_all(repls, s):
    for k,v in repls:
        s = s.replace(k, v)
    return s

def re_sub_all(re_subs, s):
    for k,v in re_subs:
        s, num_subs = re.subn(k, v, s, flags=re.DOTALL)
        #print "Number of substitutions for %s-->%s: %d" % (k, v, num_subs)
    return s

def get_re_subs_for_all():
    repls = [("int serialVersionUID", "long serialVersionUID"),
             ("short serialVersionUID", "long serialVersionUID"),
             ("byte serialVersionUID", "long serialVersionUID"),
             ("Long.POSITIVE_INFINITY", "Long.MAX_VALUE"),
             ("Long.NEGATIVE_INFINITY", "Long.MIN_VALUE"),
             ("Int.POSITIVE_INFINITY", "Integer.MAX_VALUE"),
             ("Int.NEGATIVE_INFINITY", "Integer.MIN_VALUE"),
             ("Short.POSITIVE_INFINITY", "Short.MAX_VALUE"),
             ("Short.NEGATIVE_INFINITY", "Short.MIN_VALUE"),
             ("Byte.POSITIVE_INFINITY", "Byte.MAX_VALUE"),
             ("Byte.NEGATIVE_INFINITY", "Byte.MIN_VALUE"),
             ]
    
    # Convert repls to regex replacements.
    re_subs = [(re.escape(k), v) for k, v in repls]
    return re_subs

def get_re_subs_for_single(src_prim, dest_prim):
    '''Gets regular expression pairs for use in re.subn (called by re_sub_all). 
        For use when a single source document, is copied and a single primative type 
        is replaced.'''
    repls = []
    add_re_subs = []
    
    if src_prim.prim == "long" and dest_prim.prim == "int":
        repls += [("Long.", "Integer.")]
    repls += get_typedef_repls(src_prim, dest_prim)
    
    # Convert repls to regex replacements.
    re_subs = [(re.escape(k), v) for k, v in repls]
    re_subs += get_re_subs_for_all() 
    re_subs += add_re_subs
           
    return re_subs
    
def get_re_subs_for_pair(dest_key, dest_val):    
    '''Gets regular expression pairs for use in re.subn (called by re_sub_all). 
        For use when a pair of source documents, is copied and the key and 
        value primatives are replaced.'''
    tds = get_typedefs()
    src_key = tds.get("long")
    src_val = tds.get("double")
    
    # Pairs (as tuples) of strings which should be replace exactly.
    repls = []
        
    # Prepend some replacements for generics in the unit tests. 
    if dest_key.prim == "int":
        repls += [("<Long,", "<Integer,")]
        repls += [("<Long>", "<Integer>")]
        repls += [(" Long ", " Integer ")]
        repls += [("Long.", "Integer.")]
    if dest_val.prim == "int":
        repls += [(",Double>", ",Integer>")]
        repls += [(", Double>", ", Integer>")]
        repls += [("<Double>", "<Integer>")]
        repls += [(" Double ", " Integer ")]
        repls += [("(Double ", "(Integer ")]
    # Conditional replacements
    if dest_val.is_integral:
        repls += [(", double delta", ""),
                  (", delta", ""),
                  (", double zeroThreshold", ""),
                  (", zeroThreshold", ""),
                  (", 1e-13", ""),
                  (", Primitives.DEFAULT_DOUBLE_DELTA", ""),
                  ]
        
    # Add the primary replacements.
    repls += get_typedef_repls(src_key, dest_key)
    repls += get_typedef_repls(src_val, dest_val)
    
    # Additional regular expression replacements to be concatenated at the end.
    add_re_subs = []
    
    # Excluded code.
    if dest_val.is_integral:
        add_re_subs += [
            # Remove everything between the markers.
            (r"START EXCLUDE ILV (\S+).*END EXCLUDE \1", ""),
            ]
    else:
        add_re_subs += [
            # Just remove the markers.
            (r"(START EXCLUDE ILV (\S+)|END EXCLUDE (\S+))", ""),
            ]
        
    if dest_val.prim == "int":
        add_re_subs += [
            # Remove everything between the markers.
            (r"START EXCLUDE IV (\S+).*END EXCLUDE \1", ""),
            ]
    else:
        add_re_subs += [
            # Just remove the markers.
            (r"(START EXCLUDE IV (\S+)|END EXCLUDE (\S+))", ""),
            ]
        
    if dest_key.prim == "int" and dest_val.prim == "int":
        add_re_subs += [
            # Remove everything between the markers.
            (r"START EXCLUDE IK IV (\S+).*END EXCLUDE \1", ""),
            ]
    else:
        add_re_subs += [
            # Just remove the markers.
            (r"(START EXCLUDE IK IV (\S+)|END EXCLUDE (\S+))", ""),
            ]
        
    # Other regex replacements
    add_re_subs += [(r"SafeCast\.safeIntToInt\(([^\)]+)\)", r"\1"),
               ]
    
    # Convert repls to regex replacements.
    re_subs = [(re.escape(k), v) for k, v in repls]
    re_subs += get_re_subs_for_all() 
    re_subs += add_re_subs
           
    return re_subs

def copy_and_sub(re_subs, src_files):
    dest_files = map(lambda f : re_sub_all(re_subs, f), src_files)
    dest_files = [x.replace("/java/", "/java_generated/") for x in dest_files]
    for sf, df in zip(src_files, dest_files):
        assert sf != df
        print "Current destination file:", df
        dest_str = file_to_str(sf)
        dest_str = re_sub_all(re_subs, dest_str)
        str_to_file(dest_str, df)
        
def copy_single(src_prim, dest_prim, src_files):
    '''Copies a class defined for a source primitive to a new class with the destination primitive.
    '''
    re_subs = get_re_subs_for_single(src_prim, dest_prim)
    copy_and_sub(re_subs, src_files)

def copy_pair(dest_key, dest_val, src_files):
    '''Copies a set of classes defined with key=Long, value=Double primitives to a new class
        using key=dest_key and value=dest_val.
    '''
    re_subs = get_re_subs_for_pair(dest_key, dest_val)
    copy_and_sub(re_subs, src_files)

def classes_to_files(main_test, classes):
    java = os.path.join("src", main_test, "java")
    src_files = [os.path.join(java, c.replace(".", "/") + ".java") for c in classes]
    return src_files

if __name__ == "__main__":
    tds = get_typedefs()
    
    # ------------------ Copy Primitive Type Pairs --------------------
    #
    # Create a list of main/test classes which are defined for a pair of primitives (Long and Double)
    # and should be copied over to a new pair of primitives.    
    src_files = classes_to_files("main", [
                    "edu.jhu.prim.map.LongDoubleMap",
                    "edu.jhu.prim.map.LongDoubleEntry",
                    "edu.jhu.prim.map.LongDoubleSortedMap",
                    "edu.jhu.prim.map.LongDoubleHashMap",
                    "edu.jhu.prim.sort.LongDoubleSort",
                    "edu.jhu.prim.vector.LongDoubleVector",
                    "edu.jhu.prim.vector.LongDoubleSortedVector",
                    "edu.jhu.prim.vector.LongDoubleUnsortedVector",
                    "edu.jhu.prim.vector.LongDoubleHashVector",
                    "edu.jhu.prim.vector.LongDoubleDenseVector",
                    "edu.jhu.prim.vector.LongDoubleVectorSlice",
                    "edu.jhu.prim.vector.AbstractLongDoubleVector",
                    ]) + \
                classes_to_files("test", [
                    "edu.jhu.prim.map.LongDoubleSortedMapTest",
                    "edu.jhu.prim.map.LongDoubleHashMapTest",
                    "edu.jhu.prim.sort.LongDoubleSortTest",
                    "edu.jhu.prim.vector.LongDoubleSortedVectorTest",
                    "edu.jhu.prim.vector.LongDoubleUnsortedVectorTest",
                    "edu.jhu.prim.vector.LongDoubleHashVectorTest",
                    "edu.jhu.prim.vector.LongDoubleDenseVectorTest",
                    "edu.jhu.prim.vector.LongDoubleVectorSliceTest",
                    "edu.jhu.prim.vector.AbstractLongDoubleVectorTest",
                    ])
    copy_pair(tds.get("int"), tds.get("double"), src_files)
    copy_pair(tds.get("int"), tds.get("float"), src_files)
    copy_pair(tds.get("int"), tds.get("long"), src_files)    
    copy_pair(tds.get("long"), tds.get("int"), src_files)
    copy_pair(tds.get("int"), tds.get("int"), src_files)    
    # TODO: ShortInt doesn't work because the literal 0 must be manually cast to a short.
    src_files = classes_to_files("main", ["edu.jhu.prim.sort.LongDoubleSort"]) + \
                classes_to_files("test", ["edu.jhu.prim.sort.LongDoubleSortTest"])
    copy_pair(tds.get("int"), tds.get("short"), src_files)
    
    # ------------------ Copy Primitive Type Singletons --------------------
    #
    # Create a list of main/test classes which are defined for a single primitive
    # and should be copied over to a primitive.
    
    # Float only
    src_files = classes_to_files("main", [
                    "edu.jhu.prim.arrays.DoubleArrays",
                    "edu.jhu.prim.sort.DoubleSort",
                    "edu.jhu.prim.list.DoubleArrayList",
                    "edu.jhu.prim.list.DoubleStack",
                    ]) + \
                classes_to_files("test", [
                    "edu.jhu.prim.sort.DoubleSortTest",
                    "edu.jhu.prim.util.DoubleJUnitUtils",
                    ]) 
    copy_single(tds.get("double"), tds.get("float"), src_files)
    # Boolean, Byte, Short, Int
    src_files = classes_to_files("main", [
                    "edu.jhu.prim.arrays.LongArrays",
                    "edu.jhu.prim.sort.LongSort",
                    "edu.jhu.prim.list.LongArrayList",
                    "edu.jhu.prim.list.LongStack",
                    ]) + \
                classes_to_files("test", [
                    "edu.jhu.prim.sort.LongSortTest",
                    "edu.jhu.prim.util.LongJUnitUtils",
                    ])
    copy_single(tds.get("long"), tds.get("short"), src_files)
    copy_single(tds.get("long"), tds.get("byte"), src_files)
    copy_single(tds.get("long"), tds.get("int"), src_files)
    # Int only
    src_files = classes_to_files("main", [
                    "edu.jhu.prim.set.LongHashSet",
                    "edu.jhu.prim.set.LongSet",
                    "edu.jhu.prim.iter.LongIter",
                    "edu.jhu.prim.iter.LongArrayIter",
                    "edu.jhu.prim.iter.LongIncrIter",
                    ]) 
    copy_single(tds.get("long"), tds.get("int"), src_files)
