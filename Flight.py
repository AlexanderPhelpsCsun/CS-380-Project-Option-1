import random

class flight:
    def __init__(self, origin, destination, price):
        self.orgin = origin
        self.destination = destination
        self.price = price
        self.isFull = random.choice([True, True, True, True, False])
        #^ 1/5 chance of it being full

    def __str__(self):
        if(self.is_full==True):
            status ="Full"
        else:
            status = "Available"
        return f"{self.origin} to {self.destination}, ${self.price} ({Status})"
