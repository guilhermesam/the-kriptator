import enchant
from utils import *

"""
Julius Caesar used a system of cryptography, now known as Caesar Cipher,
which shifted each letter 2 places further through the alphabet (e.g. 'A'
shifts to 'C', 'R' shifts to 'T', etc.). At the end of the alphabet we wrap
around, that is 'Y' shifts to 'A'. We can, of course, try shifting by any
number.
"""

ALPHABET = "abcdefghijklmnopqrstuvwxyz"


def hack(message):
    dictionary = enchant.Dict('en-US')
    attempts = list()
    for execution in range(1, 28):
        if dictionary.check(decrypt(message, execution).split('-')[0]):
            attempts.append(export_colors()['YELLOW'] + f"Try#{execution}: " + decrypt(message, execution).
                            replace("-", " "))
        else:
            attempts.append(export_colors()['MAGENTA'] + f"Try#{execution}: " + export_colors()['RESET'] +
                            decrypt(message, execution).replace("-", " "))
    return attempts


def encrypt(message, times):

    if times > 26:
        times = times % 26

    message_encrypted_vector = list()
    message = filter_input(message)
    words = message.split("-")
    result = list()
    symbols = ['"', '(', ')']

    for word in words:
        for letter in word:
            if letter in symbols:
                message_encrypted_vector.append(letter)
            else:
                index = ALPHABET.index(letter)
                message_encrypted_vector.append(switch_alphabet_root(times)[index])
        message_encrypted_vector.append("-")

    result.append("".join(message_encrypted_vector))

    return "".join(result)[:-1]


def decrypt(message, times):
    message = filter_input(message)
    message_encrypted_vector = list()
    words = message.split("-")
    result = list()
    symbols = ['"', '(', ')']

    for word in words:
        for letter in word:
            if letter in symbols:
                message_encrypted_vector.append(letter)
            else:
                index = ALPHABET.index(letter)
                message_encrypted_vector.append(switch_alphabet_root(26 - times)[index])
        message_encrypted_vector.append("-")

    result.append("".join(message_encrypted_vector))

    return "".join(result)[:-1]


def main():
    print(export_colors()['GREEN'] + '==== Welcome to Caesar Cipher Decoder ====' + export_colors()['RESET'])
    run = "y"

    while run == 'y':
        print('what operation do you want to perform ?')
        print('1: Encrypt')
        print('2: Decrypt')
        print('3: Decrypt (without passing number of shifties)')
        print('', end='--> ')
        operation = int(input(''))

        if operation == 1:
            message = input('Type a message: ')
            times = int(input('Type the number os shifties: '))
            print(encrypt(message, times))

        elif operation == 2:
            message = input('Type a message: ')
            times = int(input('Type the number os shifties: '))
            print(decrypt(message, times))

        elif operation == 3:
            message = input('Type a message: ')
            for string in hack(message):
                print(string)

        else:
            print('insert an valid operation!' + '\n')

        run = input('Do you want to ' + export_colors()['MAGENTA'] + 'try again? ' + export_colors()['RESET'] +
                    '(y/n) ' + '\n').lower()

    print(export_colors()['YELLOW'] + 'Farewell :)')


main()
