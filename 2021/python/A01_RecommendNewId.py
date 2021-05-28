def solution( new_id):

    answer = ''
    # 1
    new_id = new_id.lower()
    print('1step ', new_id)

    # 2
    for c in new_id:
        if c.isalpha() or c.isdigit() or c in ['-', '_', '.']:
            answer += c
    # 3
    while '..' in answer:
        answer = answer.replace('..', '.')
    print('3step ', answer)
    # 4
    if answer[0] == '.':
        answer = answer[1:] if len(answer) > 1 else '.'
        # answer = answer[1:]
    if answer[-1] == '.':
        answer = answer[:-1]
    print('4step ', new_id)

    # 5
    if answer == '':
        answer = 'a'

    # 6
    if len(answer) > 15:
        answer = answer[:15]
        if answer[-1] == '.':
            answer = answer[:-1]

    # 7
    while len(answer) < 3:
        answer += answer[-1]
    return answer

if __name__ == "__main__":
    # print("result:",solution( "...!@BaT#*..y.abcdefghijklm"))
    print("result:", solution("=.="))
