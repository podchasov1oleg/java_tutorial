package homework9;

import java.sql.*;

public class Cat {
    private static PreparedStatement ps;

    private long id;
    private final String name;
    private final String type;
    private final String furLength;
    private final String originCountry;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Cat(String name, String type, String furLength, String originCountry) {
        this.name = name;
        this.type = type;
        this.furLength = furLength;
        this.originCountry = originCountry;
    }

    public static void createTable(Connection connection) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS cats (" +
            "    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
            "    name TEXT NOT NULL," +
            "    type TEXT NOT NULL," +
            "    fur_length TEXT NOT NULL," +
            "    origin_country TEXT NOT NULL" +
            ");");
    }

    public long create(Connection connection) throws SQLException {
        ps = connection.prepareStatement(
            "INSERT INTO cats(name, type, fur_length, origin_country) VALUES (?, ?, ?, ?);",
            Statement.RETURN_GENERATED_KEYS
        );
        ps.setString(1, this.name);
        ps.setString(2, this.type);
        ps.setString(3, this.furLength);
        ps.setString(4, this.originCountry);
        ps.executeUpdate();
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if (generatedKeys.next()) {
            long id = generatedKeys.getLong(1);
            this.setId(id);
            return id;
        }
        return 0;
    }

    public String read(Connection connection) throws SQLException {
        ps = connection.prepareStatement("SELECT * FROM cats WHERE ID = ?;");
        ps.setLong(1, this.id);
        ResultSet rs = ps.executeQuery();
        return String.format(
            "Кот по кличке %s, порода %s, %s, страна происхождения: %s",
            rs.getString("name"),
            rs.getString("type"),
            rs.getString("fur_length"),
            rs.getString("origin_country")
        );
    }

    public boolean update(Connection connection, String... props) throws SQLException {
        ps = connection.prepareStatement("UPDATE cats SET name = ?, type = ?, fur_length = ?, origin_country = ? WHERE ID = ?;");
        for (int i = 1; i <= 4; i++) {
            if (props.length > i - 1) {
                ps.setString(i, props[i - 1]);
            } else {
                ps.setString(i, "");
            }
        }
        ps.setLong(5, this.id);

        return ps.execute();
    }

    public boolean delete(Connection connection) throws SQLException {
        ps = connection.prepareStatement("DELETE FROM cats WHERE ID = ?;");
        ps.setLong(1, this.id);

        if (ps.execute()) {
            this.id = 0;
            return true;
        } else {
            return false;
        }
    }
}
