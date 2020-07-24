from caesar_cipher import switch_alphabet_root

ALPHABET = "abcdefghijklmnopqrstuvwxyz"
COLORS = {
    'RED': '\033[31m',
    'GREEN': '\033[32m',
    'YELLOW': '\033[33m',
    'MAGENTA': '\033[35m',
    'RESET': '\033[0;0m'
}

def generate_table():
    table = list()
    for times in range(0, 26):
        table.append(switch_alphabet_root(times))
    return table


def encrypt(key, message):
    encrypted_message = list()

    for index in range(0, len(key)):
        x = ALPHABET.index(key[index])
        y = ALPHABET.index(message[index])
        encrypted_message.append(switch_alphabet_root(y)[x])

    return "".join(encrypted_message)


print(encrypt('bom', 'bom'))
