
antal_år = 0
summa_år = 0
max_år = 0
min_år = 110

inmatat_år = -1
print("Mata in födelseårtal. För att avsluta, ange talet 0.")
while inmatat_år != 0:
    inmatat_år = int(input("Årtal: "))
    alder = 2020 - inmatat_år
    if (alder < 0 or alder > 110) and alder != 2020:
        print("Orimligt årtal. Försök igen.")
    else:
        if inmatat_år > 0:
            antal_år += 1
            summa_år = summa_år + alder
            if alder < min_år:
                min_år = alder
            if alder > max_år:
                max_år = alder

print(f"Medelåldern är {summa_år/antal_år}. Den yngsta är {min_år} och den äldsta är {max_år}.")