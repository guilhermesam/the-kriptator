"""
Julius Caesar used a system of cryptography, now known as Caesar Cipher,
which shifted each letter 2 places further through the alphabet (e.g. 'A'
shifts to 'C', 'R' shifts to 'T', etc.). At the end of the alphabet we wrap
around, that is 'Y' shifts to 'A'. We can, of course, try shifting by any
number.
"""

# TODO: Verificar existência de libs de NLP, regulamentar entrada de dados, alterar cores do terminal;

ALPHABET = "abcdefghijklmnopqrstuvwxyz"


def switch_alphabet_root(times):
    pt1 = ALPHABET[times:len(ALPHABET)]
    pt2 = ALPHABET[0: times]
    return pt1 + pt2


def hack(message):
    for execution in range(0, 27):
        print(f"Try#{execution}", decrypt(message, execution).replace("-", " "))


def encrypt(message, times):
    message_encrypted_vector = list()
    words = message.split(" ")
    result = list()

    for word in words:
        for letter in word:
            index = ALPHABET.index(letter)
            message_encrypted_vector.append(switch_alphabet_root(times)[index])
        message_encrypted_vector.append("-")

    result.append("".join(message_encrypted_vector))

    return "".join(result)[:-1]


def decrypt(message, times):
    message = message.replace(" ", "-")
    message_encrypted_vector = list()
    words = message.split("-")
    result = list()

    for word in words:
        for letter in word:
            index = ALPHABET.index(letter)
            message_encrypted_vector.append(switch_alphabet_root(26 - times)[index])
        message_encrypted_vector.append("-")

    result.append("".join(message_encrypted_vector))

    return "".join(result)[:-1]


hack("fcjjm-kw-lykc-gq-esgjfcpkc-ylb-g-jgic-amddcc")
