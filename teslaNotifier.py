from yahoo_fin import stock_info

ticker = input("Enter the company's ticker symbol: ").upper()

price = stock_info.get_live_price(ticker)
print(f"{ticker}: {price}")

if price < 700:
    print("buy buy")
else:
    print("hold hold")