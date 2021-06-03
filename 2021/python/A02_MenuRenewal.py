from itertools import combinations


def solution(orders, course):
    answer = []
    dic = dict()

    for order in orders:
        for num in course:
            comb = list(combinations(order, num))
            for c in comb:
                c = list(c)
                c.sort()
                c = ''.join(c)
                if c in dic:
                    dic[c] += 1
                else:
                    dic[c] = 1

    for c in course:
        max_value = 0
        for k, v in sorted(dic.items(), key=lambda x: x[1], reverse=True):
            if v >= 2 and len(k) == c:
                if v >= max_value:
                    answer.append(k)
                    max_value = v

    return sorted(answer)


print(solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"],[2,3,4]))
# print(solution(["AC", "ACE", "ACDE", "CDE"], [2, 3, 4]))
