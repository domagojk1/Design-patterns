package utils;

import builder.Diver;
import builder.Schedule;
import chain.observer.FederationObserver;
import constants.FederationLevel;
import constants.ProLevels;
import constants.RecreationalLevels;
import chain.observer.singleton.DivingClub;

import java.io.*;
import java.util.*;

/**
 * Created by domagoj on 10/19/16.
 */
public class FileWriter {

    public static void writeTable(String fileName, ArrayList<DiveEvent> events) {
        DivingClub club = DivingClub.getInstance();

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(fileName, "UTF-8");
            writer.println(String.format("%15s","Ime\tDubina\tVrijeme\tDatum\tSigurnost"));
            writer.println(String.format("%15s", "-------------------------------------------------"));

            for (DiveEvent diveEvent : events) {
                for (Diver diver : diveEvent.getDivers()) {

                    String toWrite = diver.getName() + "\t"
                            + diver.getDepth() + "\t"
                            + diveEvent.getSchedule().getDivingTime() + "\t"
                            + diveEvent.getSchedule().getDivingDate() + "\t"
                            + diveEvent.getSafetyLevel();
                    writer.println(String.format("%15s", toWrite));
                    writer.println(String.format("%15s", "-------------------------------------------------"));
                }
            }
            writer.println("\n\n");

            int sumDepth = 0;
            int diversNum = 0;
            Map<FederationObserver, ArrayList<DiveEvent>> map = club.getObserverMap();

            writer.println("Statisticki podaci:\n");
            writer.println(String.format("%20s", "Federacija\tBroj urona\tProsjecna dubina\tBroj ronioca"));
            writer.println(String.format("%20s", "-----------------------------------------------------------------------"));

            for (Map.Entry<FederationObserver, ArrayList<DiveEvent>> entry : map.entrySet()) {
                sumDepth = 0;
                diversNum = 0;
                ArrayList<DiveEvent> diveEvents = entry.getValue();
                diversNum = diveEvents.size();

                for (DiveEvent event : diveEvents) {
                    sumDepth += event.getDivers().get(0).getDepth();
                }

                writer.println(String.format("%5s", entry.getKey().getName()) + "\t" + "\t\t" + diversNum + "\t\t" + (sumDepth / diversNum) + "\t\t" + diversNum);
                writer.println(String.format("%20s", "-----------------------------------------------------------------------"));
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        finally {
            if (writer != null) writer.close();
        }
    }

    public static void write (String fileName, ArrayList<DiveEvent> events) {
        PrintWriter writer = null;

        ArrayList<Diver> participants = new ArrayList<>();

        try {
            writer = new PrintWriter(fileName, "UTF-8");

            writer.println("RONJENJA:");
            writer.println("-----------------------------------------------------");

            for (DiveEvent event : events) {
                writer.println("Datum i vrijeme urona: " +
                             event.getSchedule().getDivingDate() +
                             " " +
                             event.getSchedule().getDivingTime());
                writer.println("Maksimalna dubina: " + event.getSchedule().getMaxDivingDepth());
                writer.println("Grupa:");
                for (Diver diver : event.getDivers()) {
                    writer.println(diver.getName() + ", maksimalna dubina: " + event.getSchedule().getMaxDivingDepth());


                    if (!participants.contains(diver)) participants.add(diver);
                }
                writer.println();
            }

            writer.println("RONIOCI:");
            writer.println("-----------------------------------------------------");

            for (Diver participant : participants) {
                String realLevel = "";
                String sign = participant.getLevel().getLevelSign();

                if (sign.startsWith(RecreationalLevels.RECREATIONAL)) {
                    String federation = participant.getLevel().getFederation();

                    switch (federation) {
                        case "SSI":
                            for (FederationLevel federationLevel : RecreationalLevels.SSI) {
                                if (federationLevel.getLevelSign().equals(sign)) {
                                    realLevel = federationLevel.getFederation();
                                }
                            }
                            break;
                        case "BSAC":
                            for (FederationLevel federationLevel : RecreationalLevels.BSAC) {
                                if (federationLevel.getLevelSign().equals(sign)) {
                                    realLevel = federationLevel.getFederation();
                                }
                            }
                            break;
                        case "CMAS":
                            for (FederationLevel federationLevel : RecreationalLevels.CMAS) {
                                if (federationLevel.getLevelSign().equals(sign)) {
                                    realLevel = federationLevel.getFederation();
                                }
                            }
                            break;
                        case "NAUI":
                            for (FederationLevel federationLevel : RecreationalLevels.NAUI) {
                                if (federationLevel.getLevelSign().equals(sign)) {
                                    realLevel = federationLevel.getFederation();
                                }
                            }
                            break;
                    }
                }
                else if (participant.getLevel().getLevelSign().startsWith(ProLevels.PRO)) {
                    String federation = participant.getLevel().getFederation();

                    switch (federation) {
                        case "SSI":
                            for (FederationLevel federationLevel : ProLevels.SSI) {
                                if (federationLevel.getLevelSign().equals(sign)) {
                                    realLevel = federationLevel.getFederation();
                                }
                            }
                            break;
                        case "BSAC":
                            for (FederationLevel federationLevel : ProLevels.BSAC) {
                                if (federationLevel.getLevelSign().equals(sign)) {
                                    realLevel = federationLevel.getFederation();
                                }
                            }
                            break;
                        case "CMAS":
                            for (FederationLevel federationLevel : ProLevels.CMAS) {
                                if (federationLevel.getLevelSign().equals(sign)) {
                                    realLevel = federationLevel.getFederation();
                                }
                            }
                            break;
                        case "NAUI":
                            for (FederationLevel federationLevel : ProLevels.NAUI) {
                                if (federationLevel.getLevelSign().equals(sign)) {
                                    realLevel = federationLevel.getFederation();
                                }
                            }
                            break;
                    }
                }

                writer.println (participant.getName() + " "
                        + participant.getDateOfBirth() + " "
                        + participant.getLevel().getFederation() + " "
                        + realLevel);

                writer.println ("Sudjelovao/la u ronjenjima:");

                for (DiveEvent event : events) {
                     if (event.getDivers().contains(participant)) {
                         writer.println (event.getSchedule().getDivingDate() + " " + event.getSchedule().getDivingTime());
                     }
                }

                writer.println("\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) writer.close();
        }
    }

    public static ArrayList<Object> readFromFile(String fileName, Class<?> cls) {
        ArrayList<Object> objects = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    if (cls == Diver.class) {
                        Diver diver = new Diver.DiverBuilder(line)
                                .setDOB()
                                .setLevel()
                                .setName().build();
                        objects.add(diver);
                    }
                    else if (cls == Schedule.class) {
                        Schedule schedule = new Schedule.ScheduleBuilder(line).build();
                        objects.add(schedule);
                    }
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Datoteka " + fileName + " ne postoji.");
        }
        catch (IOException e) {
            System.out.println("Pogreska prilikom citanja datoteke " + fileName + ".");
        }

        return objects;
    }
}
