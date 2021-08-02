def dec2bin( värde, antal_bitar):
    while antal_bitar != 0:
        bitvärde = pow(2, antal_bitar-1)

        if värde >= bitvärde:
            print("1", end = "")
            värde = värde - bitvärde
        else:
            print("0", end = "")
        
        antal_bitar = antal_bitar - 1

invärde_ok = False
invärde = 0

while invärde_ok == False:
    print("Ange ett värde")
    invärde = int(input())
    if invärde > 65535:
        print("Fel. Kan inte hantera så stora tal. Försök igen")
    else:
        if invärde < 0:
            print("Fel. Kan bara hantera positiva tal. Försök igen.")
        else:
            invärde_ok = True

if invärde < 256:
    print(f"Talet {invärde} ryms i en byte och blir binärt: ", end = "")
    dec2bin(invärde, 8)
else:
    print(f"Talet {invärde} ryms i 16 bitar och blir binärt: ", end = "")
    dec2bin(invärde, 16)
