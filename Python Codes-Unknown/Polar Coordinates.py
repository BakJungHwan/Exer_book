import cmath

if __name__ == "__main__" :
    temp = input()
    if '+' in temp :
        arr = temp.split('+')
        arr[1] = arr[1][:-1]
        arr = list(map(float,arr))
    else :
        if temp[0] == '-' :
            arr = temp.split('-')
            arr[1] = arr[1][:-1]
            arr = list(map(float,arr))
            arr[0] *= (-1)
            arr[1] *= (-1)
        else :
            arr = temp.split('-')
            arr[1] = arr[1][:-1]
            arr = list(map(float,arr))
            arr[1] *= (-1)
    
    print(abs(complex(arr[0], arr[1])))
    print(cmath.phase(complex(arr[0],arr[1])))
    
    
