def printGrid(grid):
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            print(grid[i][j],end=" ")
        print()
    print()

# def findNext(grid, rc):
#     count=0
#     for i in range(len(grid)):
#         for j in range(len(grid[0])):
#             if grid[i][j]!="+":
#                 rc[0]=i
#                 rc[1]=j
#                 return True
#     return False

def rowCheck(grid,rc,word):
    r=rc[0]
    c=rc[1]
    rlen=0
    for i in range(c,c+len(word)):
        if (grid[r][i]=="+" or i>=len(grid[0])-1):
            return False
    return True

def colCheck(grid,rc,word):
    r=rc[0]
    c=rc[1]
    clen=0
    for i in range(r,r+len(word)):
        if (grid[i][c]=="+" or i>=len(grid)-1):
            return False
    return True

def rowFit(grid,rc,word):
    r=rc[0]
    c=rc[1]
    for i in range(c,c+len(word)):
        if (i>len(grid[0])-1):
            return False
        if (not(grid[r][i]=="-" or grid[r][i]==word[i-c])):
            return False
    return True

def colFit(grid,rc,word):
    r=rc[0]
    c=rc[1]
    for i in range(r,r+len(word)):
        if (i>len(grid)-1):
            return False
        if (not(grid[i][c]=="-" or grid[i][c]==word[i-r])):
            return False
    return True

def rowIsSafe(grid,rc,word):
    return rowFit(grid,rc,word)
    # return (len(word)==rowCheck(grid,rc) and rowFit(grid,rc,word))

def colIsSafe(grid,rc,word):
    return colFit(grid,rc,word)
    # return (len(word)==colCheck(grid,rc) and colFit(grid,rc,word))

def rowPlace(grid,rc,word):
    r=rc[0]
    c=rc[1]
    orig=""
    for i in range(c,c+len(word)):
        orig+=(grid[r][i])
        grid[r][i]=word[i-c]
    return orig

def colPlace(grid,rc,word):
    r=rc[0]
    c=rc[1]
    orig=""
    for i in range(r,r+len(word)):
        orig+=(grid[i][c])
        grid[i][c]=word[i-r]
    return orig


# def solveCrossword(grid, words):
#     rc=[0,0]

#     if (not findNext(grid,rc)):
#         return True
    

#     for i in range(len(words)):
#         word=words[i]
#         if (rowIsSafe(grid,rc,word)):
#             orig=rowPlace(grid,rc,word)
#             words.remove(word)

#             if (solveCrossword(grid,words)):
#                 return True
            
#             words.insert(i,word)
#             rowPlace(grid,rc,word)
    
#     for i in range(len(words)):
#         word=words[i]
#         if (colIsSafe(grid,rc,word)):
#             orig=colPlace(grid,rc,word)
#             words.remove(word)

#             if (solveCrossword(grid,words)):
#                 return True
            
#             words.insert(i,word)
#             colPlace(grid,rc,word)
    
#     return False

def solveCrossword(grid, words):
    rc=[0,0]

    if (len(words)==0):
        return True
    for p in range(len(grid)):
        for q in range(len(grid[0])):
            rc[0]=p
            rc[1]=q
            if (grid[p][q]=="+"):
                # print("skipped", p, q)
                continue

            for i in range(len(words)):
                word=words[i]
                if (rowIsSafe(grid,rc,word)):
                    orig=rowPlace(grid,rc,word)
                    words.remove(word)
                    # printGrid(grid)

                    if (solveCrossword(grid,words)):
                        return True
                    
                    words.insert(i,word)
                    rowPlace(grid,rc,orig)
            
            for i in range(len(words)):
                word=words[i]
                if (colIsSafe(grid,rc,word)):
                    orig=colPlace(grid,rc,word)
                    words.remove(word)

                    if (solveCrossword(grid,words)):
                        return True
                    
                    words.insert(i,word)
                    colPlace(grid,rc,orig)
            
    return False






grid=[
    ["+","-","+","+","+","+","+","+","+","+"],
    ["+","-","+","+","-","+","+","+","+","+"],
    ["+","-","-","-","-","-","-","-","+","+"],
    ["+","-","+","+","-","+","+","+","+","+"],
    ["+","-","+","+","-","+","+","+","+","+"],
    ["+","-","+","+","-","+","+","+","+","+"],
    ["+","+","+","+","-","+","+","+","+","+"],
    ["+","+","+","+","-","+","+","+","+","+"],
    ["+","+","+","+","+","+","+","+","+","+"],
    ["-","-","-","-","-","-","-","-","-","-"]
    ]
    
words=["CALIFORNIA","NIGERIA","CANADA","TELAVIV"]

print(solveCrossword(grid,words))

printGrid(grid)