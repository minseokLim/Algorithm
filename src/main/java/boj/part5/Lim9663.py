n = int(input())
answer = 0
row = [0] * n


def dfs(x):
    global n, answer, row

    if x == n:
        answer += 1
        return

    for i in range(n):
        row[x] = i
        if check(x):
            dfs(x + 1)


def check(x):
    for i in range(x):
        if row[x] == row[i] or abs(row[x] - row[i]) == abs(x - i):
            return False

    return True


dfs(0)
print(answer)
