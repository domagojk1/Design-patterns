package feature;

import builder.Diver;
import constants.FederationLevel;
import constants.ProLevels;
import constants.RecreationalLevels;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


/**
 * Created by domagoj on 10/19/16.
 */
public class FileWriter {
    public static void write (String fileName, ArrayList<DiveEvent> events) {
        PrintWriter writer = null;

        ArrayList<Diver> participants = new ArrayList<>();

        try {
            writer = new PrintWriter(fileName, "UTF-8");

            writer.println("RONJENJA:");
            writer.println("-----------------------------------------------------");

            for (DiveEvent event : events) {
                writer.println("Datum i vrijeme urona grupe: " +
                             event.getSchedule().getDivingDate() +
                             " " +
                             event.getSchedule().getDivingTime());
                writer.println("Maksimalna dubina: " + event.getSchedule().getMaxDivingDepth());
                writer.println("Maksimalan broj ronioca: " + event.getSchedule().getDiversNum());
                writer.println("Ronioci:");
                for (Diver diver : event.getDivers()) {
                    writer.println(diver.getName() + ", razina: " + diver.getLevel().getLevelSign() + ", dubina: " + diver.getDepth());

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
                                if (federationLevel.getSign().equals(sign)) {
                                    realLevel = federationLevel.getName();
                                }
                            }
                            break;
                        case "BSAC":
                            for (FederationLevel federationLevel : RecreationalLevels.BSAC) {
                                if (federationLevel.getSign().equals(sign)) {
                                    realLevel = federationLevel.getName();
                                }
                            }
                            break;
                        case "CMAS":
                            for (FederationLevel federationLevel : RecreationalLevels.CMAS) {
                                if (federationLevel.getSign().equals(sign)) {
                                    realLevel = federationLevel.getName();
                                }
                            }
                            break;
                        case "NAUI":
                            for (FederationLevel federationLevel : RecreationalLevels.NAUI) {
                                if (federationLevel.getSign().equals(sign)) {
                                    realLevel = federationLevel.getName();
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
                                if (federationLevel.getSign().equals(sign)) {
                                    realLevel = federationLevel.getName();
                                }
                            }
                            break;
                        case "BSAC":
                            for (FederationLevel federationLevel : ProLevels.BSAC) {
                                if (federationLevel.getSign().equals(sign)) {
                                    realLevel = federationLevel.getName();
                                }
                            }
                            break;
                        case "CMAS":
                            for (FederationLevel federationLevel : ProLevels.CMAS) {
                                if (federationLevel.getSign().equals(sign)) {
                                    realLevel = federationLevel.getName();
                                }
                            }
                            break;
                        case "NAUI":
                            for (FederationLevel federationLevel : ProLevels.NAUI) {
                                if (federationLevel.getSign().equals(sign)) {
                                    realLevel = federationLevel.getName();
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
                writer.println("----------------------------");

                for (DiveEvent event : events) {
                     if (event.getDivers().contains(participant)) {
                         writer.println("\n");
                         writer.println (event.getSchedule().getDivingDate() + " " + event.getSchedule().getDivingTime());
                         writer.println ("Max. dubina: " + participant.getDepth());
                         
                         writer.println("Partneri:");
                         for (Diver diver : event.getDivers()) {
                             writer.println(diver.getName());
                         }
                        
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
}
