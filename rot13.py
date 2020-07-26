import caesar_cipher

"""
ROT13 cipher refers to the abbreviated form Rotate by 13 places. It is a special case of Caesar Cipher in which
shift is always 13. Every letter is shifted by 13 places to encrypt or decrypt the message.
"""


def decrypt(message):
    return caesar_cipher.decrypt(message, 13)


def encrypt(message):
    return caesar_cipher.encrypt(message, 13)