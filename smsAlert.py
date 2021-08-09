msg = "1337 - ELIT!"

from twilio.rest import Client
import schedule
cell_nr = "+46727366262"
twilio_nr = "+12532012556"

def send_message(msg):
    account = "AC2081f7c047c9b8f6313950461bf03193"
    token = "e9ed0069b51f5aab84d405720b378d69"
    client = Client(account, token)
    client.messages.create(to=cell_nr, from_=twilio_nr, body=msg)

schedule.every().day.at("13:37").do(send_message(msg))