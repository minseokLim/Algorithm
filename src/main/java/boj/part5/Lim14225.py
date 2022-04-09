def dfs(idx, sequence, part_sum):
    part_sum += sequence[idx]
    possible_part_sums.add(part_sum)
    j = idx + 1
    while j < len(sequence):
        dfs(j, sequence, part_sum)
        j += 1


def get_min(part_sums):
    sorted_sums = sorted(part_sums)
    j = 0

    while j < len(part_sums):
        if j + 1 != sorted_sums[j]:
            return j + 1
        j += 1

    return j + 1


n = int(input())
seq = sorted(map(int, input().split()))
possible_part_sums = set()

i = 0
while i < len(seq):
    dfs(i, seq, 0)
    i += 1

print(get_min(possible_part_sums))
