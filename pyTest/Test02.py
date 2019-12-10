file = open("/Users/bay/Downloads/11.txt", "r")
print(file.name)
reads = file.readlines()
line = 1
for read in reads:
    print(line)
    line += 1
    print(read)
