
board = [[" "," "," "],[" "," "," "],[" "," "," "]]

def printBoard(board):
    print(f"{board[0][0]} | {board[0][1]} | {board[0][2]} ")
    print("--+---+--")
    print(f"{board[1][0]} | {board[1][1]} | {board[1][2]} ")
    print("--+---+--")
    print(f"{board[2][0]} | {board[2][1]} | {board[2][2]} ")


message = f"Welcome to TicTacToe! You are playing as X, please choose your first move:"

print(message)
printBoard(board)

def threeInARow(player):
    if board[0][0] == board[0][1] == board[0][2] != " ":
        printBoard(board)
        print(f"Player {player} has Won!")
        True
    else:
        False

while threeInARow("X") and threeInARow("O"):
    print("No")