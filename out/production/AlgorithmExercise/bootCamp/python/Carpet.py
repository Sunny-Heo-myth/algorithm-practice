
def solution(brown, yellow) :
    
    for width in range(1, yellow + 1) :
        
        if yellow % width == 0 :
            height = yellow / width

            if (width + 2) * (height + 2) - yellow == brown :

                if width >= height :
                    return [width + 2, height + 2]
                else :
                    return [height + 2, width + 2]
                    
