import time

def part1(f):
    horizontal = 0
    depth = 0
    line = f.readline()
    change = int(' '.join(filter(str.isdigit, line)))
    if 'forward' in line:
        horizontal  += change
    if 'down' in line:
        depth += change 
    if 'up' in line:
        depth -= change
    while line:
        line = f.readline()
        if("forward" in line or "down" in line or "up" in line):
            change = int(' '.join(filter(str.isdigit, line)))
        if "forward" in line:
            horizontal  += change
        if "down" in line:
            depth += change
        if "up" in line:
            depth -= change
    print(horizontal*depth)  # should return 1451208 (without aim)

def part2(f):
    horizontal = 0
    depth = 0
    aim = 0 # part 2
    line = f.readline()
    change = int(' '.join(filter(str.isdigit, line)))
    if 'forward' in line:
        horizontal  += change
    if 'down' in line:
        aim += change # part 2
    if 'up' in line:
        aim -= change # part 2
    while line:
        line = f.readline()
        if("forward" in line or "down" in line or "up" in line):
            change = int(' '.join(filter(str.isdigit, line)))
        if "forward" in line:
            horizontal  += change
            depth += (change*aim) # part 2
        if "down" in line:
            aim += change # part 2
        if "up" in line:
            aim -= change # part 2 
    print(horizontal*depth)  # should return 1620141160 with aim

# part 1
f = open("day2/input.txt", "r")
t0 = time.time() * 1000
part1(f)
t1 = time.time() * 1000
total = t1-t0
print("Total time (part 1): " + str(total) + 'sß')

# part 2
t0 = time.time() * 1000
f.seek(0)
part2(f)
t1 = time.time() * 1000
f.close()
total = t1-t0
print("Total time (part 2): " + str(total) +  's')
