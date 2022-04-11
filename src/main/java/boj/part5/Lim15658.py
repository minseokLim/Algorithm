def dfs(operator_idx, seq_idx, value):
    global min_value, max_value, seq, operator_count

    operator_count[operator_idx] -= 1

    if operator_idx == 0:
        value = value + seq[seq_idx]
    elif operator_idx == 1:
        value = value - seq[seq_idx]
    elif operator_idx == 2:
        value = value * seq[seq_idx]
    else:
        value = int(value / seq[seq_idx])

    if seq_idx == len(seq) - 1:
        if min_value > value:
            min_value = value
        if max_value < value:
            max_value = value

        return

    j = 0
    while j < 4:
        if operator_count[j] > 0:
            dfs(j, seq_idx + 1, value)
            operator_count[j] += 1

        j += 1


n = int(input())
seq = list(map(int, input().split()))
operator_count = list(map(int, input().split()))
min_value = 10_0000_0000
max_value = -10_0000_0000

i = 0
while i < 4:
    if operator_count[i] > 0:
        dfs(i, 1, seq[0])
        operator_count[i] += 1

    i += 1

print(max_value)
print(min_value)
