package thinIceController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CSVHandling {
	private String dataSource;
	private String dataExport;
	private String[][] commands;
	private String[] state;

	public CSVHandling() {
		this.commands = null;
		this.dataSource = null;
		this.dataExport = null;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource)throws IOException {
		this.dataSource = dataSource;
		if (dataSource == null) {
			commands = null;
		} else
			readCSV();
	}

   public String getDataExport() {
      return dataExport;
   }

   public void setDataExport(String dataExport) {
      if(dataExport!= null)
         this.dataExport = dataExport;
   }

	public String[][] requestCommands() {
		return commands;
	}

   public void exportState(String[] state) {
      this.state = state;
      writeCSV();
   }

   private void readCSV() throws IOException {
			BufferedReader file = new BufferedReader(new FileReader(dataSource));

			String line = file.readLine();
			int i = 0;
			commands = new String[285][];
			while (line != null) {
				commands[i] = line.split(",");
				line = file.readLine();
				i++;
			}
			file.close();
	}
	
	private void writeCSV(){
		try {
			PrintWriter fileExport = new PrintWriter(new FileWriter(dataExport, true));
			if (state != null)
			   for (int s = 0; s < state.length; s++)
			      fileExport.println(state[s]);
			fileExport.close();
		}catch(IOException erro){
			erro.printStackTrace();
		}
	}
}