import random





class flightDataBase:

    airports = [
        "LAX", "SFO", "SEA", "SAN", "PDX",  # West Coast
        "ORD", "MSP", "DTW",  # Midwest
        "JFK", "EWR", "BOS", "DCA", "IAD", "PHL",  # East Coast
        "ATL", "MIA", "DFW", "IAH", "CLT", "BNA", "MCO",  # South
        "DEN", "PHX", "SLC"  # Mountain West
        ]

    x=random.randint(0,len(airports))
    y=random.randint(0,len(airports))

    while(x==y):
        y=random.randint(0,len(airports)-1)

    numberOfFlights = random.randint(13, 43)

    flights=[]
    

    for i in range(numberOfFlights):  # 13 to 34 random flights
        x, y = random.sample(airports, 2)   # Pick two different airports
        price = random.randint(49, 1193)
        flights.append(f"{x} to {y}, ${price}")
    
    for flight in flights:
        print(flight)
        

    
