package Handlers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class CRUD {
	public void create(String filename, ArrayList<String> thingsTobeCreated) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(filename, true);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);

			// save the data at the new line.
			for (int i = 0; i < thingsTobeCreated.size(); i++) {
				if (i == 0) {
					pw.print(thingsTobeCreated.get(i) + "~");
				} else if (i == thingsTobeCreated.size() - 1) {
					pw.print(thingsTobeCreated.get(i) + "\n");
				} else {
					pw.print(thingsTobeCreated.get(i) + "~");

				}
			}
			pw.flush();
			pw.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No such file exists.");

		} finally {
			try {
				pw.flush();
				pw.close();
				fw.close();
				bw.close();
			} catch (IOException ex) {
			}

		}
	}

	// overloading
	// Read all value
	public ArrayList<ArrayList<String>> read(String filename) {
		File file = new File(filename);

		FileReader fileReader = null;
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		BufferedReader br = null;

		try {
			fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);

			String line;

			while ((line = br.readLine()) != null) {
				ArrayList<String> tempList = new ArrayList<>();

				String[] wordsInLine = line.split("~");
				boolean singleFlag = false;
				boolean flag1 = false;
				boolean flag2 = false;

				for (int i = 0; i < wordsInLine.length; i++) {

					tempList.add(wordsInLine[i]);

				}
				result.add(tempList);

			}
			
			fileReader.close();
			br.close();

		} catch (FileNotFoundException ex) {
		} catch (IOException ex) {
		} finally {
//
//			try {
//				fileReader.close();
//				br.close();
//			} catch (IOException ex) {
//			}

		}

		return result;
	}

	// retrieve only one row of data. Powerfullsearch will return rows of data
	public HashMap<Integer, String> read(String filename, String param1, int pos1, String param2, int pos2) {
		File file = new File(filename);

		FileReader fileReader = null;
		String[] tempResult = {};
		HashMap<Integer, String> result = new HashMap<>();
		BufferedReader br = null;

		try {
			fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);
			boolean found = false;

			String line;
			while ((line = br.readLine()) != null && found == false) {
				String[] wordsInLine = line.split("~");
				
				boolean singleFlag = false;
				boolean flag1 = false;
				boolean flag2 = false;
				
				if(param2.equals("") && pos2 == 0) {
					singleFlag = true;
				}
				
				if(singleFlag) {
					if(wordsInLine[pos1].equals(param1)) {
						System.out.println("here");
						tempResult = wordsInLine;
					}
				} else {
					if(wordsInLine[pos1].equals(param1) && wordsInLine[pos2].equals(param2)) {
						tempResult = wordsInLine;
					}
				}
				
				
			}

			fileReader.close();
			br.close();
			

		} catch (FileNotFoundException ex) {
		} catch (IOException ex) {
		}
		
		for(int i = 0; i <tempResult.length; i ++ ) {
			result.put(i, tempResult[i]);
		}

		return result;
	}
	
	//BulkRead
    public ArrayList<ArrayList<String>> readBulk(String filename, String param1, int pos1, String param2, int pos2) {
        File file = new File(filename);

        FileReader fileReader = null;
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        BufferedReader br = null;

        try {
            fileReader = new FileReader(file);
            br = new BufferedReader(fileReader);
            boolean found = false;

            String line = br.readLine();

            int j = 0;
            while (line != null) {
                String[] wordsInLine = line.split("~");
                boolean singleFlag = false;
                boolean flag1 = false;
                boolean flag2 = false;
                boolean noFlag = false;
                ArrayList<String> tempList = new ArrayList<>();

                for (int i = 0; i < wordsInLine.length; i++) {
                    tempList.add(wordsInLine[i]);
                    if (param1.equals("all")) {
                        noFlag = true;
                        System.out.println("retrieve all results");

                    } else if ((!param1.isEmpty() && !param2.isEmpty()) || (!param1.isBlank() && !param2.isBlank())) {
                        if (i == pos1 && param1.equals(wordsInLine[i])) {
                            flag1 = true;
                            System.out.println("First param found");
                        } else if (i == pos2 && param2.equals(wordsInLine[i])) {
                            flag2 = true;
                            System.out.println("Second param found");

                        }
                    } else {
                        if (i == pos1 && param1.equals(wordsInLine[i])) {
                            singleFlag = true;
                            System.out.println("single param found");

                        }
                    }
                }

                if ((flag1 == true && flag2 == true) || singleFlag == true) {
                    result.add(tempList);
                    j++;
                } else if (noFlag == true) {
                    result.add(tempList);
                    j++;
                } else {
                    tempList.clear();

                }
                line = br.readLine();
            }

            if (result == null) {
                System.out.println("No result");

            } else {
                System.out.println("Result found " + result.size());

            }

            br.close();
            fileReader.close();

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {

            try {
                br.close();
                fileReader.close();

            } catch (IOException ex) {
            }

        }

        return result;
    }
	
	// Update one or two values in the row
    public void update(String filename, String param1, int pos1, String param2, int pos2, String change1, int changePos1, String change2,
            int changePos2) {
        String newFileName = "tempfile.txt";
        File newFile = new File(newFileName);
        File oldfile = new File(filename);
        FileReader fileReader;

        try {
            FileWriter fw = new FileWriter(newFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            fileReader = new FileReader(oldfile);
            BufferedReader brRead = new BufferedReader(fileReader);

            String line = brRead.readLine();

            while (line != null) {

                String[] wordsInLine = line.split("~");
                boolean singleFlag = false;
                boolean flag1 = false;
                boolean flag2 = false;

                ArrayList<String> tempArray = new ArrayList<>();
                //read the line and check if that line is the line mentioned to be updated
                for (int i = 0; i < wordsInLine.length; i++) {

                    //add all the word into an arraylist(tempArray) first, no matter it is going to be altered or not, so tat the bottom part can write the tempfile according to the tempArray.
                    tempArray.add(wordsInLine[i]);
                    if ((!param1.isEmpty() && !param2.isEmpty()) || (!param1.isBlank() && !param2.isBlank())) {

                        if (i == pos1 && param1.equals(wordsInLine[i])) {

                            flag1 = true;
                            System.out.println("First param found");
                        } else if (i == pos2 && param2.equals(wordsInLine[i])) {

                            flag2 = true;
                            System.out.println("Second param found");
                        }
                    } else {

                        if (i == pos1 && param1.equals(wordsInLine[i])) {
                            singleFlag = true;
                            System.out.println("single param found");
                        }
                    }
                }

                //bw.newLine();  this syntax will auto space a line, so instead, "\n" is use to continue the data to the next line.
                //if the line is mentioned to be updated, write the file
                if ((flag1 == true && flag2 == true) || singleFlag == true) {

                    for (int i = 0; i < tempArray.size(); i++) {
                        String parameterTobeChecked = tempArray.get(i);

                        if (i == 0) {

                            addDataIntoFileUpdate(pw, parameterTobeChecked, i, true, change1, change2, changePos1, changePos2);
                        } else if (i == tempArray.size() - 1) {

                            addDataIntoFileUpdate(pw, parameterTobeChecked, i, false, change1, change2, changePos1, changePos2);

                        } else {

                            addDataIntoFileUpdate(pw, parameterTobeChecked, i, true, change1, change2, changePos1, changePos2);
                        }

                    }

                } else {
                    if (!tempArray.get(0).isEmpty()) {

                        for (int i = 0; i < tempArray.size(); i++) {
                            String originalValue = tempArray.get(i);

                            if (i == 0) {
                                pw.print(originalValue + "~");
                            } else if (i == tempArray.size() - 1) {
                                pw.print(originalValue + "\n");

                            } else {
                                pw.print(originalValue + "~");
                            }
                        }
                    }
                }
                line = brRead.readLine();
            }

            pw.flush();
            pw.close();
            bw.close();
            brRead.close();
            fileReader.close();
            //need to close all the stream be4 deleting the file

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {

            oldfile.delete();

            File latest = new File(filename);

            newFile.renameTo(latest);
            System.out.println("File is updated");
        }

    }
    
    private void addDataIntoFileUpdate(PrintWriter pw, String originalValue, int currentPos, boolean valueAngle, String change1, String change2,
            int changePos1, int changePos2) {
        //valueAngle : True(value at Front,Middle) , False(value at End)
        String printValue1stParamSame = null;
        String printValue2ndParamSame = null;
        String printValueNoParamSame = null;

        if (valueAngle == false) {
            printValue1stParamSame = change1 + "\n";
            printValue2ndParamSame = change2 + "\n";
            printValueNoParamSame = originalValue + "\n";

        } else if (valueAngle == true) {
            printValue1stParamSame = change1 + "~";
            printValue2ndParamSame = change2 + "~";
            printValueNoParamSame = originalValue + "~";
        }
        System.out.println("CheckPoint6.1.1.1");

        if ((!change1.isEmpty() && !change2.isEmpty()) || (!change1.isBlank() && !change2.isBlank())) {
            System.out.println("CheckPoint6.1.1.2 " + change1 + " " + change2);
            if (currentPos == changePos1) {
                System.out.println("CheckPoint6.1.1.3 " + change1 + " " + change2);

                pw.print(printValue1stParamSame);
                System.out.println("First param found");

            } else if (currentPos == changePos2) {
                System.out.println("CheckPoint6.1.1.4 " + change1 + " " + change2);

                pw.print(printValue2ndParamSame);
                System.out.println("Second param found");
            } else {
                pw.print(printValueNoParamSame);
                System.out.println("CheckPoint6.1.1.5 " + change1 + " " + change2);

            }
        } else {
            if (currentPos == changePos1) {
                System.out.println("CheckPoint6.1.1.6 " + change1 + " " + change2);

                pw.print(printValue1stParamSame);
                System.out.println("single param found");

            } else {
                System.out.println("CheckPoint6.1.1.7 " + change1 + " " + change2);

                pw.print(printValueNoParamSame);

            }
        }

    }
    
    // Update the row with the new values
    public void updateRow(String filename, String param1,
            int pos1, String param2,
            int pos2, ArrayList<String> dataArray
    ) {
        String newFileName = "tempfile.txt";
        File newFile = new File(newFileName);
        File oldfile = new File(filename);
        FileReader fileReader;

        try {
            FileWriter fw = new FileWriter(newFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            fileReader = new FileReader(oldfile);
            BufferedReader brRead = new BufferedReader(fileReader);

            String line;

            while ((line = brRead.readLine()) != null) {

                String[] wordsInLine = line.split("~");
                boolean singleFlag = false;
                boolean flag1 = false;
                boolean flag2 = false;
                ArrayList<String> tempArray = new ArrayList<>();

                //read the line and check if that line is the line mentioned to be updated
                for (int i = 0; i < wordsInLine.length; i++) {

                    //add all the word into an arraylist(tempArray) first, no matter it is going to be altered or not, so tat the bottom part can write the tempfile according to the tempArray.
                    tempArray.add(wordsInLine[i]);
                    if ((!param1.isEmpty() && !param2.isEmpty()) || (!param1.isBlank() && !param2.isBlank())) {

                        if (i == pos1 && param1.equals(wordsInLine[i])) {

                            flag1 = true;
                            System.out.println("First param found");
                        } else if (i == pos2 && param2.equals(wordsInLine[i])) {

                            flag2 = true;
                            System.out.println("Second param found");
                        }
                    } else {

                        if (i == pos1 && param1.equals(wordsInLine[i])) {
                            singleFlag = true;
                            System.out.println("single param found");
                        }
                    }
                }

                //bw.newLine();  this syntax will auto space a line, so instead, "\n" is use to continue the data to the next line.
                //if the line is mentioned to be updated, write the file
                if ((flag1 == true && flag2 == true) || singleFlag == true) {

                    for (int i = 0; i < dataArray.size(); i++) {

                        String parameterTobeChecked = dataArray.get(i);

                        if (i == 0) {
                            pw.print(parameterTobeChecked + "~");
                        } else if (i == dataArray.size() - 1) {
                            pw.print(parameterTobeChecked + "\n");

                        } else {
                            pw.print(parameterTobeChecked + "~");
                        }

                    }

                } else {
                    if (!tempArray.get(0).isEmpty()) {

                        for (int i = 0; i < tempArray.size(); i++) {
                            String originalValue = tempArray.get(i);

                            if (i == 0) {
                                pw.print(originalValue + "~");
                            } else if (i == tempArray.size() - 1) {
                                pw.print(originalValue + "\n");

                            } else {
                                pw.print(originalValue + "~");
                            }
                        }
                    }
                }
            }

            pw.flush();
            pw.close();
            bw.close();
            brRead.close();
            fileReader.close();

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            oldfile.delete();

            File latest = new File(filename);

            newFile.renameTo(latest);
            System.out.println("File is updated");
        }
    }
    
    public void delete(String filename, String param1, int pos1, String param2, int pos2) {
        String newFileName = "tempfile.txt";
        File newFile = new File(newFileName);
        File oldfile = new File(filename);
        FileReader fileReader = null;

        try {
            FileWriter fw = new FileWriter(newFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            fileReader = new FileReader(oldfile);
            BufferedReader brRead = new BufferedReader(fileReader);

            String line = brRead.readLine();

            while (line != null) {

                String[] wordsInLine = line.split("~");
                boolean singleFlag = false;
                boolean flag1 = false;
                boolean flag2 = false;
                ArrayList<String> tempArray = new ArrayList<>();

                //read the line and check if that line is the line mentioned to be updated
                for (int i = 0; i < wordsInLine.length; i++) {

                    //add all the word into an arraylist(tempArray) first, no matter it is going to be altered or not, so tat the bottom part can write the tempfile according to the tempArray.
                    tempArray.add(wordsInLine[i]);
                    if ((!param1.isEmpty() && !param2.isEmpty()) || (!param1.isBlank() && !param2.isBlank())) {

                        if (i == pos1 && param1.equals(wordsInLine[i])) {

                            flag1 = true;
                            System.out.println("First param found");
                        } else if (i == pos2 && param2.equals(wordsInLine[i])) {

                            flag2 = true;
                            System.out.println("Second param found");
                        }
                    } else {

                        if (i == pos1 && param1.equals(wordsInLine[i])) {
                            singleFlag = true;
                            System.out.println("single param found");
                        }
                    }
                }

                //bw.newLine();  this syntax will auto space a line, so instead, "\n" is use to continue the data to the next line.
                //if the line is mentioned to be updated, write the file
                if ((flag1 == false && flag2 == false) && singleFlag == false) {
                    if (!tempArray.get(0).isEmpty()) {

                        for (int i = 0; i < tempArray.size(); i++) {
                            String originalValue = tempArray.get(i);

                            if (i == 0) {
                                pw.print(originalValue + "~");
                            } else if (i == tempArray.size() - 1) {
                                pw.print(originalValue + "\n");

                            } else {
                                pw.print(originalValue + "~");
                            }
                        }
                    }

                }
                line = brRead.readLine();
            }

            pw.flush();
            pw.close();
            bw.close();
            brRead.close();
            fileReader.close();
            //need to close all the stream be4 deleting the file

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            oldfile.delete();

            File latest = new File(filename);

            newFile.renameTo(latest);

            System.out.println("File is deleted");
        }
    }
}