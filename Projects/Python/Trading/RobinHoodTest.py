import robin_stocks as rs
import time
import numpy as np



class Portfolio:
    def __init__(self):
        rs.login(username = "ArnavMohapatra", password = "8wB@uTAx0kWvleQA", by_sms=True, store_session=True)
        self.pf = []

    def add(self, stock=None, amount=0):
        try:
            if(amount>=0):
                self.pf.append([stock, 0, amount])
            else:
                print("Invalid Amount")
        except:
            print("Invalid Stock Ticker")
    def update_prices(self):
        for s in self.pf:
            bids = np.array(rs.get_latest_price(s[0], priceType="bid_price")).astype(np.float)
            s[1] = np.median(bids, axis = 0)

    def report(self):
        print("Portfolio:")
        print("      ", "Stock", "  Price", "   Shares")
        for s in self.pf:
            print("     -", s[0]+ ":  ", s[1], "     ", s[2])
        print()
        print("Portfolio Value: $", np.sum([s[1]*s[2] for s in self.pf]))


p = Portfolio()
p.add("TSLA", .01)
p.add("MNKD", 1)

for x in range(12):
    p.update_prices()
    p.report()
    time.sleep(5)

rs.logout()