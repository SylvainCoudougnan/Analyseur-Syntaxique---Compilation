package fr.ubordeaux.deptinfo.compilation.lea;


import fr.ubordeaux.deptinfo.compilation.lea.parser.Parser.Location;
import fr.ubordeaux.deptinfo.compilation.lea.type.Type;

public class SwitchStack
	{
		public Type type;
		public Location loc; 
		public Integer count; // numero du case dans le switch (numero 1 = premier case du switch, etc)

		public SwitchStack(Type type, Location loc, Integer count)
		{
			this.type = type; 
			this.loc = loc;
			this.count = count;
		}
	} 