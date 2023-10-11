def fb(n):

    a=0 # a is the first number in fabonacci  series.
    b=1 # b  is second number in fabonacci series .
    print(a)
    print(b)
    """
    by printing the above condition the fabonacci series is : 0 1 1 and so till n 
    """
    for i in range(2,n+1): # by using for it will iterate till n
        c=a+b
        a=b
        b=c
        print(c)

print(fb(n)) #enter the value of n in postive integer by which u want to calculate fabonacci series.