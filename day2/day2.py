import time

def part1():
    with open("day2/input.txt") as f:
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
    
    print(horizontal*depth) # should return 1451208 (without aim)

def part2():
    with open("day2/input.txt") as f:
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
        
    print(horizontal*depth) # should return 1451208 without aim, 1621592368 with aim

t0 = time.time()
part1()
t1 = time.time()
total = t1-t0
print("Total time (part 1): " + str(total))
t0 = time.time()
part2()
t1 = time.time()
total = t1-t0
print("Total time (part 2): " + str(total))
