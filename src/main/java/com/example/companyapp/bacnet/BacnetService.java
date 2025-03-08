package com.example.companyapp.bacnet;

import com.serotonin.bacnet4j.LocalDevice;
import com.serotonin.bacnet4j.RemoteDevice;
import com.serotonin.bacnet4j.event.DeviceEventAdapter;
import com.serotonin.bacnet4j.service.confirmed.ReadPropertyRequest;
import com.serotonin.bacnet4j.service.confirmed.WritePropertyRequest;
import com.serotonin.bacnet4j.type.constructed.ObjectIdentifier;
import com.serotonin.bacnet4j.type.enumerated.PropertyIdentifier;
import com.serotonin.bacnet4j.type.primitive.Real;
import org.springframework.stereotype.Service;

@Service
public class BacnetService {
    private final LocalDevice localDevice;

    public BacnetService() throws Exception {
        localDevice = new LocalDevice(12345, 47808);
        localDevice.getEventHandler().addListener(new DeviceEventAdapter() {
            @Override
            public void iAmReceived(RemoteDevice d) {
                System.out.println("Discovered device: " + d);
            }
        });
        localDevice.initialize();
    }

    public void readProperty(int deviceId, int objectType, int objectInstance, PropertyIdentifier property) throws Exception {
        ObjectIdentifier objectId = new ObjectIdentifier(objectType, objectInstance);
        ReadPropertyRequest request = new ReadPropertyRequest(objectId, property);
        System.out.println("Read request sent for: " + objectId);
        // Placeholder: Replace with actual request handling once the device is available
    }

    public void writeProperty(int deviceId, int objectType, int objectInstance, PropertyIdentifier property, float value) throws Exception {
        ObjectIdentifier objectId = new ObjectIdentifier(objectType, objectInstance);
        WritePropertyRequest request = new WritePropertyRequest(objectId, property, null, new Real(value));
        System.out.println("Write request sent for: " + objectId + " value: " + value);
        // Placeholder: Replace with actual request handling once the device is available
    }
}
