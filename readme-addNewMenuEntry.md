
# Add table with Sensor-Messungen

1) eclipse install

2) install maven plugin 

3) import maven project  (right click - write "maven")
- existing maven project
- choose proper path

4) (a1) create new view page (xhtml) 
- into the folder pages
- duplicate greet.xhtml -> sensor.xhtml

5) (a1) add entry to view menu (xhtml)
		<p:menuitem value="Sensor" outcome="pretty:sensorView"
			icon="ui-icon-person">
			<f:param name="i" value="7" />
		</p:menuitem>


6) (a1) route definition in controller (first e.g GreetController.java)
- sensorView

@URLMapping(id = "sensorView", pattern = "/sensor/", viewId = "/pages/sensor.xhtml")

7) compile and deploy

8) table with values on interface 
- copy from create.xhtml (user) into sensor.xhtml
- modify table tag
	- var: sensormeasurement
	- value: "#{sensorController.sensormeasurements}"
	- modify columns - header + content

9) create SensorController.java (from createController) 
- add get all measures (after constructor)
- use dao obj to access db
- use SensorMeasurement objects for data transport
	
10) create SensorMeasurement.java (duplicate user)
- entity fields

11) create SensorMeasurementDao - interface
- only with the method getAll()

12) implement interface in  EJBSensorMeasurementDao 
- content of the getAll method


