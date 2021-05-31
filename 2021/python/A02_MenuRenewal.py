from itertools import combinations
def solution(orders, course):
    answer = []

    #orders를 정렬된 리스트로 바꾼다.
    for i in range(len(orders)):
        orders[i]=sorted(list(orders[i]))
        print(orders)

    for i in course:
        dic=dict()
        for order in orders:
            for j in combinations(order,i):
                temp = ''.join(j)
                if temp in dic:
                    dic[temp]+=1
                else:
                    dic[temp]=1
        if dic:
            max_v=dic[max(dic,key=lambda x:dic[x])]
        for k in dic:
            if dic[k]==1:
                continue
            if dic[k]==max_v:
                answer.append(k)
    answer = sorted(answer)
    return answer

# print(solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"],[2,3,4]))
print(solution(["XYZ", "XWY", "WXA"],[2,3,4]))
