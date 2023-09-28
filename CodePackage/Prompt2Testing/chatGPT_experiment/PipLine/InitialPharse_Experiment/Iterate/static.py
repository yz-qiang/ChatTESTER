import json

path = './RepairCompile.json'
with open(path, 'r', encoding='utf-8') as f:
    file_cont = json.load(f)

# patth2 = './RepairTest.json'
# with open(patth2, 'r', encoding='utf-8') as f:
#     file = json.load(f)


count2 = []
count = []
for cont in file_cont:
    count.append(cont['count'])

# for cont in file:
#     count2.append(cont['count'])

pp = list(set(count))
print(pp)
print(len(list(set(count))))

pp = list(set(count2))
print(pp)
print(len(list(set(count2))))