# 🌌 SkNebula

SkNebula currently serves one purpose: adding an event listener for the "player digging" serverbound packet.

## Available Syntax
**Events**
- `[on] player dig[ging]`: Fired when a "player digging" packet is received from a client
    - `[the] dig status`: The dig status of the packet
      - `start digging`
      - `cancel digging`
      - `stop digging`
      - `all items dropped`
      - `item dropped`
      - `release item`
      - `swap item`
    - `event-player`: The player that the packet originated from
    - `event-location`: The location of the block
    - `event-block`: The block at event-location
    
### Examples
```
on player dig:
    the dig status is start digging:
        send "[!] You started breaking a block!" to event-player
    else if the dig status is cancel digging:
        cancelledDiggingHandler(event-player) # Not a real function, just an example
```