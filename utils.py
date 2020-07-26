def filter_input(message):
    symbols = [',', '!', '.', '@', '/', '?']
    for symbol in symbols:
        message = message.replace(symbol, '')
    message = message.replace(' ', '-')
    return message


def export_colors():
    return {
        'RED': '\033[31m',
        'GREEN': '\033[32m',
        'YELLOW': '\033[33m',
        'MAGENTA': '\033[35m',
        'RESET': '\033[0;0m'
    }


def switch_alphabet_root(times):
    alphabet = "abcdefghijklmnopqrstuvwxyz"
    pt1 = alphabet[times:len(alphabet)]
    pt2 = alphabet[0: times]
    return pt1 + pt2
