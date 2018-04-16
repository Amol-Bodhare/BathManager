# BathManager
* An android application to check the current status of Bathroom (Vacant/Engaged). This application uses Master - Slave architecture. When an user uses the bathroom, the user needs to switch the toggle button in his/her application from VACANT to ENGAGED and vice-versa. This enables his device to behave as master and starts listening to slaves requests. At this point, if another user checks the status of the bathroom, he will request a status from the master device and receive an engaged status. If at any point, there is no Master listening then the bathroom is Vacant.

## Note:

This application is still under development phase, might not have all the feature mentioned above!
