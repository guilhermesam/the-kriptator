import caesar_cipher as caesar
import vigenere_cipher as vigenere

print('Welcome to the-kriptator 1.0')

operation = int(input('Which operation do you want to perform? '))

if operation == 1:
    caesar.main()

elif operation == 2:
    vigenere.main()
