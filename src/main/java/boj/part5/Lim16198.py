def dfs(idx, energy, depth):
    global n, weights, picked, max

    picked[idx] = True

    before = 0
    after = 0

    j = idx - 1
    while j >= 0:
        if not picked[j]:
            before = weights[j]
            break
        j -= 1

    j = idx + 1
    while j < n:
        if not picked[j]:
            after = weights[j]
            break
        j += 1

    energy += before * after

    if depth == n - 2:
        if max < energy:
            max = energy
        return

    j = 1
    while j < n - 1:
        if not picked[j]:
            dfs(j, energy, depth + 1)
            picked[j] = False
        j += 1


n = int(input())
weights = list(map(int, input().split()))
picked = [False for k in range(n)]
max = 0

i = 1
while i < n - 1:
    dfs(i, 0, 1)
    picked[i] = False
    i += 1

print(max)
