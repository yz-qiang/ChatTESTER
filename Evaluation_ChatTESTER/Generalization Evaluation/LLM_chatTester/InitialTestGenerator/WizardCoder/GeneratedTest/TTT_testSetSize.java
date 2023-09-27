package de.waldheinz.fs.fat;
import de.waldheinz.fs.util.RamDisk;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
// original test path: waldheinz_fat32-lib###waldheinz_fat32-lib/src/test/java/de/waldheinz/fs/fat/ClusterChainTest###testSetSize
public class TTT_testSetSize {
@Test 
public void testGetSet() throws Exception{
    try (RamDisk ramdisk = RamDisk.create()) {
        byte[] buffer = TestUtils.randomBytes(5*16384+279);
        ByteBuffer bbRead = ByteBuffer.allocateDirect(buffer.length);
        FatFileSystem fs = FileSystemBuilder
               .newLinux()   
               .setDriveName("/dev/ram")    
               .addPartitionTable()        
               .withType(PartitionTableEntry.TYPE_FAT32)     
               .withStartSect(0x0000)      
               .withTotalSects(MathUtils.roundUpToPowerOfTwo(bbRead.capacity(), SectorSize.SECTOR_SIZE))      
               .build(ramdisk);            
        DirectoryEntry dirRoot = fs.getRootDirectory();        
            String fileNameA = "/filea";            
            FileTime creationTime = null;
            LastAccessTime lastAccessTime = null;
            ModificationTime modificationTime = null;
            ExtendedAttributes extendedAttrs = null;
            Entry createdFileA = dirRoot
                   .createFile(fileNameA,
                            false,           
                            true,            
                            0o644,           
                            creationTime,
                            lastAccessTime,
                            modificationTime,
                            extendedAttrs).getEntry(); 
            assertEquals(createdFileA instanceof RegularFileEntry,true,"Created regular file.");
            RegularFileEntry openedFileA = (RegularFileEntry)dirRoot.openExistingFile(fileNameA);
            assertTrue(!openedFileA.isDirectory());                
            Random r = new Random();                        
            while (!bbRead.hasRemaining()){                    
               int len=r.nextInt(bbRead.remaining()/16)+1;                   
               FileUtils.readFully(openedFileA.getInputStream(), bbRead.array(), bbRead.position(),len );               
           };                       
          assertArrayEquals(Arrays.copyOfRange(buffer,(int)(bbRead.limit()-bbRead.position()),
                  Math.min(((int)((bbRead.limit()+bbRead.position()))),buffer.length)),
                          Arrays.copyOfRange(bbRead.array(),0,
                                  Math.min((((int)(((bbRead.limit()+bbRead.position())))%16==0)?
                                         (((int)(((bbRead.limit()+bbRead.position())))/16)*16):
                                        (((int)(((bbRead.limit()+bbRead.position())))/16+1))*16
                                    ),bbRead.limit())),"Contents match after reading back written data."
              ) ;
      ClusterChain cc = new ClusterChain(null,false);
      Long fileSizeInclusivelyWrittenOnDisk =cc.setSize(5L*(1<<16));
      System.out.println("\n\tFileSize Inclusive Written On Disk : "+fileSizeInclusivelyWrittenOnDisk+"\n");
  } catch (Exception e){System.err.print(e);}  
}
}