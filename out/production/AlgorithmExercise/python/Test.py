def solution(answers):
    
    person_1 = [1, 2, 3, 4, 5]
    person_2 = [2, 1, 2, 3, 2, 4, 2, 5]
    person_3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    count_1 = 0; count_2 = 0; count_3 = 0
    answer = []
    
    for i in range(len(answers)) :
        if answers[i] == person_1[i%len(person_1)] : count_1 += 1
        if answers[i] == person_2[i%len(person_2)] : count_2 += 1
        if answers[i] == person_3[i%len(person_3)] : count_3 += 1

    answer_t = [count_1, count_2, count_3]       
    
    for person, score in enumerate(answer_t):
        if score == max(answer_t):
            answer.append(person + 1)

    return answer
