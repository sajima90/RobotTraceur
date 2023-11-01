class Outil
{
	Outil()
	{}

	public static boolean estUnEntier(String var0)
	{
		try
		{
			Integer.parseInt(var0);
			return true;
		} catch (Exception var2)
		{
			return false;
		}
	}
}