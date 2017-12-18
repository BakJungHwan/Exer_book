import math

class Complex(object):
    def __init__(self, real, imaginary):
        self.real = real
        self.imaginary = imaginary
        
    def __add__(self, no):
        return Complex(self.real + no.real, self.imaginary + no.imaginary)
    def __sub__(self, no):
        self.real -= no.real
        self.imaginary -= no.imaginary
        
    def __mul__(self, no):
        self.real = self.real*no.real + (-1)*self.imaginary*no.imaginary
        self.imaginary = self.real*no.imaginary + self.imaginary*no.real

    def __truediv__(self, no):
        self.real = (self.real*no.real + self.imaginary*no.imaginary) / (no.real**2 + no.imaginary**2)
        self.imaginary = (self.real*no.imaginary*(-1) + self.imaginary*no.real) / (no.real**2 + no.imaginary**2)

    def mod(self):
        self.real = self.real**2 + self.imaginary**2
        self.imaginary = 0

    def __str__(self):
        if self.imaginary == 0:
            result = "%.2f+0.00i" % (self.real)
        elif self.real == 0:
            if self.imaginary >= 0:
                result = "0.00+%.2fi" % (self.imaginary)
            else:
                result = "0.00-%.2fi" % (abs(self.imaginary))
        elif self.imaginary > 0:
            result = "%.2f+%.2fi" % (self.real, self.imaginary)
        else:
            result = "%.2f-%.2fi" % (self.real, abs(self.imaginary))
        return result


if __name__ == "__main__" :
    c = map(float,input().split())
    d = map(float,input().split())
    x = Complex(*c)
    y = Complex(*d)
    print(*map(str, [x+y, x-y, x*y, x/y, x.mod(), y.mod()]), sep='\n')