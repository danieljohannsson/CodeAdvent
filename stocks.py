import pandas as pd
import numpy as np
import yfinance as yf
import datetime as dt
from pandas_datareader import data as pdr 

yf.pdr_override()

stock = (input("Enter a stock ticker symbol: ")).upper()
print(f"Getting data for {stock} from:")
startyear = int(input("Year: "))
startmonth = int(input("Month: "))
startday = int(input("Day: "))

start = dt.datetime(startyear, startmonth, startday)

now = dt.datetime.now()

df = pdr.get_data_yahoo(stock, start, now)

print(df)