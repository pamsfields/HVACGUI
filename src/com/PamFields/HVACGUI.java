package com.PamFields;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by Pam on 4/2/2017.
 */
public class HVACGUI extends JFrame {
    private JPanel rootPanel;
    private JButton addServiceCallToButton;
    private JButton resolveCurrentCallButton;
    private JButton printCurrentCallsButton;
    private JButton printAllOutstandingCallsButton;
    private JButton printAllResolvedCallsButton;
    private JButton quitButton;
    private JLabel resultsLabel;
    private LinkedList<ServiceCall> todayServiceCalls;
    private LinkedList<ServiceCall> resolvedServiceCalls;

    public HVACGUI() {
        setContentPane(rootPanel);
        pack();
        setPreferredSize(new Dimension(500, 800));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        printAllOutstandingCallsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllOpenCalls();
            }
        });

        printAllResolvedCallsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllResolvedCalls();
            }
        });

        printCurrentCallsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextCall();
            }
        });


        resolveCurrentCallButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resolveServiceCall();
            }
        });

        addServiceCallToButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addServiceCall();
            }
        });
    }

    private void showAllOpenCalls() {
        System.out.println("Today's service calls are: ");

        if (todayServiceCalls.isEmpty()) {
            System.out.println("No service calls today");
        }

        // Display a numbered list of all the serviceCalls
        int callCount = 1;
        for (ServiceCall call : todayServiceCalls) {
            System.out.println("Service Call " + callCount++ + ", " + call + "\n");
        }
    }

    private void showAllResolvedCalls() {
        System.out.println("List of resolved calls: ");

        if (resolvedServiceCalls.isEmpty()) {
            System.out.println("No resolved calls");
        }

        for (ServiceCall call : resolvedServiceCalls) {
            System.out.println(call + "\n");
        }
    }

    private void showNextCall() {
        if (todayServiceCalls.isEmpty()) {
            String result = "No service calls today";
            resultsLabel.setText(result);
        } else {
            System.out.println(todayServiceCalls.peek());
        }
    }

    private void resolveServiceCall() {

        if (todayServiceCalls.isEmpty()) {
            String result = "No service calls today";
            resultsLabel.setText(result);
            return;
        }

        ServiceCall resolvedCall = todayServiceCalls.remove();    //Remove call from head of queue

        String resolution = Input.getStringInput("Enter resolution for " + resolvedCall);
        double fee = Input.getPositiveDoubleInput("Enter fee charged to customer");

        resolvedCall.setResolution(resolution);
        resolvedCall.setFee(fee);
        resolvedCall.setResolvedDate(new Date());  //default resolved date is now

        resolvedServiceCalls.add(resolvedCall);  //Add this call to the list of resolved calls

    }

    private void addServiceCall() {

        while (true) {
            resultsLabel.setText(callOptions);

            int choice = Input.getPositiveIntInput();

            if (choice == 1) {
                addFurnaceServiceCall();
            } else if (choice == 2) {
                addACServiceCall();
            } else if (choice == 3) {
                addWaterHeaterServiceCall();
            } else if (choice == 4) {
                return;
            } else {
                System.out.println("Please enter a number from the menu choices");
            }
        }
    }

    private void addFurnaceServiceCall() {

        String address = Input.getStringInput("Enter address of furnace");
        String problem = Input.getStringInput("Enter description of problem");
        Furnace.FurnaceType type = Input.getFurnaceType();
        Furnace f = new Furnace(address, problem, new Date(), type);
        todayServiceCalls.add(f);

        System.out.println("Added the following furnace to list of calls:\n" + f);
    }


    /* Get data about AC unit, create CentralAC object, add to end of queue of ServiceCalls */
    private void addACServiceCall() {

        String address = Input.getStringInput("Enter address of AC Unit");
        String problem = Input.getStringInput("Enter description of problem");
        String model = Input.getStringInput("Enter model of AC unit");

        CentralAC ac = new CentralAC(address, problem, new Date(), model);
        todayServiceCalls.add(ac);
        System.out.println("Added the following AC unit to list of calls:\n" + ac);
    }

    /* Get data about furnace, create Furnace object, add to end of queue of ServiceCalls */
    private void addWaterHeaterServiceCall() {

        String address = Input.getStringInput("Enter address of water heater");
        String problem = Input.getStringInput("Enter description of problem");
        WaterHeater.WaterHeaterType type = Input.getWaterHeaterType();
        WaterHeater wh = new WaterHeater(address, problem, new Date(), type);
        todayServiceCalls.add(wh);

        System.out.println("Added the following furnace to list of calls:\n" + wh);
    }

    String callOptions = "1. Add service call for furnace/n2. Add service call for AC unit/n3. Add service call for Water Heater/n4. Return to main menu/n" ;
}
