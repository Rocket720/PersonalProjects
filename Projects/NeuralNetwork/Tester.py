from sympy import *

x, y, z = symbols('x y z')
init_printing(use_unicode=True)

deriv = Derivative(expr, x, y, y, z, 4)
print(deriv)
