export class Flight
{
    flightId: number;
    flightName: string;
    source: string;
    destination: string;
    arrivalTime: string;
    departueTime: string;
    arrivalDate: string;
    departureDate: string;
    flightStatus: string;
    capacity: number;
    refundable: string;
    stops: number;
    rating: number;
    offerId: FlightOffer;
    economySeats: number;
    bussnessSeats: number;
    premiumSeats: number;
    

}

export interface FlightOffer
{
discount: number;
limitedOffer: string;
noOfUseAllowed:number;

offerCode: string;
offerId: number;
validity: string;
}