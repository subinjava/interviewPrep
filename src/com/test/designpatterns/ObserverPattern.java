package com.test.designpatterns;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
	
        static class CarTypeAddedNotifier {

            List<ShowRoom> showrooms = new ArrayList<ShowRoom>();

            void register(ShowRoom showroom) {
            	showrooms.add(showroom);
            } 

            void carAdded() {
                for(ShowRoom showroom: showrooms) {
                	showroom.announce();
                }
            }
        }

        static class ShowRoom {
            private String name;

            ShowRoom(String name) {
                this.name = name;
            }

            void announce() {
                System.out.println(name + " notified");
            }
        }

        public static void main(String[] args) {
        	CarTypeAddedNotifier notifier = new CarTypeAddedNotifier();
            notifier.register(new ShowRoom("ShowRoom1"));
            notifier.register(new ShowRoom("ShowRoom2"));
            notifier.register(new ShowRoom("ShowRoom3"));
            notifier.carAdded();
        }
}
