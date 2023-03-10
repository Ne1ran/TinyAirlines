package com.example.tiny_airlines;

import com.example.tiny_airlines.database.DBHandler;
import com.example.tiny_airlines.models.Flight;
import com.example.tiny_airlines.models.Passenger;
import com.example.tiny_airlines.models.Plane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class MainWindowController {

    @FXML
    private Button addNewBtn;
    @FXML
    private Button addNewFlightBtn;
    @FXML
    private Button addNewPlaneBtn;
    @FXML
    private TextField ageTF;
    @FXML
    private TextField capacityTF;
    @FXML
    private Button changeBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private ComboBox<String> countryCB;
    @FXML
    private TextField dateOfBirthTF;
    @FXML
    private Button deleteBtn;
    @FXML
    private TextField departDateTF;
    @FXML
    private TextField departTimeTF;
    @FXML
    private Button flightChangeBtn;
    @FXML
    private Button flightConfirmBtn;
    @FXML
    private Button flightDeleteBtn;
    @FXML
    private Label flightErrorLabel;
    @FXML
    private TableView<Flight> flightTV;
    @FXML
    private Label flightWorkingErrorLabel;
    @FXML
    private AnchorPane flightWorkingPanel;
    @FXML
    private ComboBox<String> genderCB;
    @FXML
    private TextField landDateTF;
    @FXML
    private TextField landLocationTF;
    @FXML
    private TextField landTimeTF;
    @FXML
    private TextField modelTF;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField passTF;
    @FXML
    private Label passengerErrorLabel;
    @FXML
    private TableView<Passenger> passengerTV;
    @FXML
    private Label passengerWorkingErrorLabel;
    @FXML
    private TextField phoneTF;
    @FXML
    private TextField pilotNameTF;
    @FXML
    private ComboBox<String> planeCB;
    @FXML
    private Button planeChangeBtn;
    @FXML
    private Button planeConfirmBtn;
    @FXML
    private Button planeDeleteBtn;
    @FXML
    private TableView<Plane> planeTV;
    @FXML
    private TextField planeTypeTF;
    @FXML
    private AnchorPane planeWorkingPanel;
    @FXML
    private TextField startLocationTF;
    @FXML
    private TextField startTrackTF;
    @FXML
    private AnchorPane userWorkingPane;
    @FXML
    private Label planeErrorLabel;
    @FXML
    private Label planeWorkingErrorLabel;
    @FXML
    private ComboBox<String> passengerFlightCB;

    private final DBHandler handler = new DBHandler();
    private String passengerOperation;
    private String flightOperation;
    private String planeOperation;
    private Passenger pickedPassenger;
    private Flight pickedFlight;
    private Plane pickedPlane;
    @FXML
    void initialize() {

        initPassengerComboBoxes();
        initFlightPlaneComboBox();

        initTables();
        initButtons();

        LoadDataInTables();
    }

    private void LoadPassengerTable(){
        double width = passengerTV.getPrefWidth()/9;
        TableColumn<Passenger, String> idTC = new TableColumn<>("ID");
        idTC.setPrefWidth(width);
        TableColumn<Passenger, String> passportTC = new TableColumn<>("Паспортные данные");
        passportTC.setPrefWidth(width);
        TableColumn<Passenger, String> phoneTC = new TableColumn<>("Номер телефона");
        phoneTC.setPrefWidth(width);
        TableColumn<Passenger, String> nameTC = new TableColumn<>("ФИО");
        nameTC.setPrefWidth(width);
        TableColumn<Passenger, String> ageTC = new TableColumn<>("Возраст");
        ageTC.setPrefWidth(width);
        TableColumn<Passenger, String> genderTC = new TableColumn<>("Пол");
        genderTC.setPrefWidth(width);
        TableColumn<Passenger, String> DoBTC = new TableColumn<>("Дата рождения");
        DoBTC.setPrefWidth(width);
        TableColumn<Passenger, String> countryTC = new TableColumn<>("Страна проживания");
        countryTC.setPrefWidth(width);
        TableColumn<Passenger, String> flightIdTC = new TableColumn<>("Номер рейса");
        flightIdTC.setPrefWidth(width);

        passengerTV.getColumns().addAll(idTC, passportTC, phoneTC, nameTC, ageTC, genderTC, DoBTC, countryTC, flightIdTC);

        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        passportTC.setCellValueFactory(new PropertyValueFactory<>("passport_num"));
        phoneTC.setCellValueFactory(new PropertyValueFactory<>("phone_num"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageTC.setCellValueFactory(new PropertyValueFactory<>("age"));
        genderTC.setCellValueFactory(new PropertyValueFactory<>("gender"));
        DoBTC.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
        countryTC.setCellValueFactory(new PropertyValueFactory<>("country"));
        flightIdTC.setCellValueFactory(new PropertyValueFactory<>("flight_id"));

        passengerTV.setRowFactory( tv -> {
            TableRow<Passenger> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() >= 1 && !row.isEmpty()){
                     pickedPassenger = row.getItem();
                }
            });
            return row ;
        });
    }

    private void LoadFlightTable(){
        double width = flightTV.getPrefWidth()/9;
        TableColumn<Flight, String> idTC = new TableColumn<>("ID");
        idTC.setPrefWidth(width);
        TableColumn<Flight, String> planeIdTC = new TableColumn<>("ID самолета");
        planeIdTC.setPrefWidth(width);
        TableColumn<Flight, String> startDateTC = new TableColumn<>("Дата отлета");
        startDateTC.setPrefWidth(width);
        TableColumn<Flight, String> startTimeTC = new TableColumn<>("Время прилета");
        startTimeTC.setPrefWidth(width);
        TableColumn<Flight, String> landDateTC = new TableColumn<>("Дата приземления");
        landDateTC.setPrefWidth(width);
        TableColumn<Flight, String> landTimeTC = new TableColumn<>("Время приземления");
        landTimeTC.setPrefWidth(width);
        TableColumn<Flight, String> startLocationTC = new TableColumn<>("Точка вылета");
        startLocationTC.setPrefWidth(width);
        TableColumn<Flight, String> landLocationTC = new TableColumn<>("Точка прибытия");
        landLocationTC.setPrefWidth(width);
        TableColumn<Flight, String> startTrack = new TableColumn<>("Дорожка");
        startTrack.setPrefWidth(width);

        flightTV.getColumns().addAll(idTC, planeIdTC, startDateTC, startTimeTC, landDateTC, landTimeTC, startLocationTC, landLocationTC, startTrack);

        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        planeIdTC.setCellValueFactory(new PropertyValueFactory<>("plane_id"));
        startDateTC.setCellValueFactory(new PropertyValueFactory<>("start_date"));
        startTimeTC.setCellValueFactory(new PropertyValueFactory<>("start_time"));
        landDateTC.setCellValueFactory(new PropertyValueFactory<>("land_date"));
        landTimeTC.setCellValueFactory(new PropertyValueFactory<>("land_time"));
        startLocationTC.setCellValueFactory(new PropertyValueFactory<>("start_location"));
        landLocationTC.setCellValueFactory(new PropertyValueFactory<>("land_location"));
        startTrack.setCellValueFactory(new PropertyValueFactory<>("start_track"));

        flightTV.setRowFactory( tv -> {
            TableRow<Flight> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() >= 1 && !row.isEmpty()){
                    pickedFlight = row.getItem();
                }
            });
            return row ;
        });
    }

    private void LoadPlaneTable(){
        double width = planeTV.getPrefWidth()/5;
        TableColumn<Plane, String> idTC = new TableColumn<>("ID");
        idTC.setPrefWidth(width);
        TableColumn<Plane, String> modelTC = new TableColumn<>("Модель самолета");
        modelTC.setPrefWidth(width);
        TableColumn<Plane, String> typeTC = new TableColumn<>("Тип самолета");
        typeTC.setPrefWidth(width);
        TableColumn<Plane, String> capacityTC = new TableColumn<>("Вместимость");
        capacityTC.setPrefWidth(width);
        TableColumn<Plane, String> pilotNameTC = new TableColumn<>("ФИО пилота");
        pilotNameTC.setPrefWidth(width);

        planeTV.getColumns().addAll(idTC, modelTC, typeTC, capacityTC, pilotNameTC);

        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        modelTC.setCellValueFactory(new PropertyValueFactory<>("model"));
        typeTC.setCellValueFactory(new PropertyValueFactory<>("type"));
        capacityTC.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        pilotNameTC.setCellValueFactory(new PropertyValueFactory<>("pilot_name"));

        planeTV.setRowFactory( tv -> {
            TableRow<Plane> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() >= 1 && !row.isEmpty()){
                    pickedPlane = row.getItem();
                }
            });
            return row ;
        });
    }

    private void LoadDataInTables(){
        LoadPassengersData();
        LoadFlightsData();
        LoadPlanesData();
    }

    private void LoadPassengersData() {
        ObservableList<Passenger> users = getUsersList();
        passengerTV.setItems(users);
    }
    private ObservableList<Passenger> getUsersList(){

        ObservableList<Passenger> list = FXCollections.observableArrayList();
        try {
            ResultSet passengerSet = handler.getAllPassengers();
            while(passengerSet.next()){
                Passenger user = new Passenger(passengerSet.getString(AllConstants.PassengerConsts.ID),
                        passengerSet.getString(AllConstants.PassengerConsts.PASSPORT),
                        passengerSet.getString(AllConstants.PassengerConsts.PHONE),
                        passengerSet.getString(AllConstants.PassengerConsts.NAME),
                        passengerSet.getString(AllConstants.PassengerConsts.AGE),
                        passengerSet.getString(AllConstants.PassengerConsts.GENDER),
                        passengerSet.getString(AllConstants.PassengerConsts.DATE_OF_BIRTH),
                        passengerSet.getString(AllConstants.PassengerConsts.COUNTRY),
                        passengerSet.getString(AllConstants.PassengerConsts.FLIGHT_ID));
                list.add(user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("GetDataException");
            e.printStackTrace();
        }
        return list;
    }
    private void LoadFlightsData() {
        ObservableList<Flight> flights = getFlightsList();
        flightTV.setItems(flights);
    }
    private ObservableList<Flight> getFlightsList(){

        ObservableList<Flight> list = FXCollections.observableArrayList();
        try {
            ResultSet flightSet = handler.getAllFlights();
            while(flightSet.next()){
                Flight flight = new Flight(flightSet.getString(AllConstants.FlightConsts.ID),
                        flightSet.getString(AllConstants.FlightConsts.PLANE_ID),
                        flightSet.getString(AllConstants.FlightConsts.START_DATE),
                        flightSet.getString(AllConstants.FlightConsts.START_TIME),
                        flightSet.getString(AllConstants.FlightConsts.LAND_DATE),
                        flightSet.getString(AllConstants.FlightConsts.LAND_TIME),
                        flightSet.getString(AllConstants.FlightConsts.START_LOCATION),
                        flightSet.getString(AllConstants.FlightConsts.LAND_LOCATION),
                        flightSet.getString(AllConstants.FlightConsts.TRACK));
                list.add(flight);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("GetDataException");
            e.printStackTrace();
        }
        return list;
    }
    private void LoadPlanesData() {
        ObservableList<Plane> planes = getPlanesList();
        planeTV.setItems(planes);
    }
    private ObservableList<Plane> getPlanesList(){

        ObservableList<Plane> list = FXCollections.observableArrayList();
        try {
            ResultSet planesSet = handler.getAllPlanes();
            while(planesSet.next()){
                Plane plane = new Plane(planesSet.getString(AllConstants.PlaneConsts.ID),
                        planesSet.getString(AllConstants.PlaneConsts.MODEL),
                        planesSet.getString(AllConstants.PlaneConsts.TYPE),
                        planesSet.getString(AllConstants.PlaneConsts.CAPACITY),
                        planesSet.getString(AllConstants.PlaneConsts.PILOT));
                list.add(plane);
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("GetDataException");
            e.printStackTrace();
        }
        return list;
    }
    private void initPassengerComboBoxes(){
        String genders = "Мужской Женский";
        String countries = "Россия США Китай Франция Великобритания Япония";


        ObservableList<String> countryList = FXCollections.observableArrayList();
        countryList.addAll(Arrays.asList(countries.split(" ")));

        ObservableList<String> genderList = FXCollections.observableArrayList();
        genderList.addAll(Arrays.asList(genders.split(" ")));

        countryCB.setItems(countryList);
        genderCB.setItems(genderList);

        initPassengerFlightsComboBox();
    }
    private void initPassengerFlightsComboBox(){
        ObservableList<String> flights = FXCollections.observableArrayList();
        try {
            ArrayList<String> StringInfo = new ArrayList<>();
            ResultSet flightsSet = handler.getAllFlights();
            while (flightsSet.next()){
                String flightInfo = flightsSet.getString(AllConstants.FlightConsts.ID) + ": " +
                        flightsSet.getString(AllConstants.FlightConsts.START_DATE) + "/" + flightsSet.getString(AllConstants.FlightConsts.START_TIME) +
                        " - " + flightsSet.getString(AllConstants.FlightConsts.LAND_DATE) + "/" + flightsSet.getString(AllConstants.FlightConsts.LAND_TIME);
                StringInfo.add(flightInfo);
            }
            flights.addAll(StringInfo);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (flights.size() == 0){
            flights.add("Рейсы не найдены. Добавьте их в базу, прежде чем добавлять на него пассажира!");
        }
        passengerFlightCB.setItems(flights);
    }
    private void initFlightPlaneComboBox(){
        ObservableList<String> planes = FXCollections.observableArrayList();
        try {
            ArrayList<String> StringInfo = new ArrayList<>();
            ResultSet planesSet = handler.getAllPlanes();
            while (planesSet.next()){
                String planeInfo = planesSet.getString(AllConstants.PlaneConsts.ID) + ": " +
                planesSet.getString(AllConstants.PlaneConsts.MODEL) + ". Пилот - " + planesSet.getString(AllConstants.PlaneConsts.PILOT);
                StringInfo.add(planeInfo);
            }
            planes.addAll(StringInfo);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (planes.size() == 0){
            planes.add("Самолеты не найдены. Добавьте их в базу, прежде чем добавлять рейс!");
        }
        planeCB.setItems(planes);
    }
    private void initPassengerButtons(){
        addNewBtn.setOnAction(Event -> {
            userWorkingPane.setVisible(!userWorkingPane.isVisible());
            passengerOperation = "add";
            System.out.println("addNewBtn");
        });

        changeBtn.setOnAction(Event -> {
            if (pickedPassenger != null) {
                userWorkingPane.setVisible(!userWorkingPane.isVisible());
            } else passengerErrorLabel.setText("Вы не выбрали пользователя для изменения!");
            passengerOperation = "update";
        });

        confirmBtn.setOnAction(Event -> {
            String name = nameTF.getText().trim();
            String passport = passTF.getText().trim();
            String age = ageTF.getText().trim();
            String phone = phoneTF.getText().trim();
            String dateOfBirth = dateOfBirthTF.getText().trim();

            String gender = "";
            if (genderCB.getSelectionModel().getSelectedItem() != null){
                gender = String.valueOf(genderCB.getSelectionModel().getSelectedItem().trim().charAt(0));
            }

            String country = "";
            if (countryCB.getSelectionModel().getSelectedItem() != null){
                country = countryCB.getSelectionModel().getSelectedItem().trim();
            }

            String flightId = "";
            if (passengerFlightCB.getSelectionModel().getSelectedItem() != null){
                String[] tempArray = passengerFlightCB.getSelectionModel().getSelectedItem().trim().split(":");
                if (tempArray.length > 1){
                    flightId = tempArray[0];
                }
            }

            if (passengerOperation.equals("add")) {
                if (!name.equals("") && !passport.equals("") && !phone.equals("") && !flightId.equals("")) {
                    Passenger passenger = new Passenger();
                    passenger.setName(name);
                    passenger.setPassport_num(passport);
                    passenger.setAge(age);
                    passenger.setPhone_num(phone);
                    passenger.setDate_of_birth(dateOfBirth);
                    passenger.setGender(gender);
                    passenger.setCountry(country);
                    passenger.setFlight_id(flightId);
                    try {
                        handler.addNewPassenger(passenger);
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    userWorkingPane.setVisible(!userWorkingPane.isVisible());
                    disposePassengerData();
                    LoadPassengersData(); //refresh

                } else passengerWorkingErrorLabel.setText("Вы не ввели все необходимые данные!");
            } else if (passengerOperation.equals("update")){
                if (!flightId.equals("")) {
                    if (!name.equals("")) {
                        pickedPassenger.setName(name);
                    }
                    if (!age.equals("")) {
                        pickedPassenger.setAge(age);
                    }
                    if (!passport.equals("")) {
                        pickedPassenger.setPassport_num(passport);
                    }
                    if (!phone.equals("")) {
                        pickedPassenger.setPhone_num(phone);
                    }
                    if (!dateOfBirth.equals("")) {
                        pickedPassenger.setDate_of_birth(dateOfBirth);
                    }
                    if (!gender.equals("")) {
                        pickedPassenger.setGender(gender);
                    }
                    if (!country.equals("")) {
                        pickedPassenger.setCountry(country);
                    }
                    pickedPassenger.setFlight_id(flightId);

                    try {
                        handler.updatePassenger(pickedPassenger);
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                    userWorkingPane.setVisible(!userWorkingPane.isVisible());
                    disposePassengerData();
                    LoadPassengersData();
                } else passengerWorkingErrorLabel.setText("Выберите номер рейса!");
            }
        });

        deleteBtn.setOnAction(Event -> {
            passengerOperation = "delete";
            if (pickedPassenger != null){
                try {
                    handler.deletePassenger(pickedPassenger.getId());
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                passengerErrorLabel.setText("");
                LoadPassengersData();
            } else passengerErrorLabel.setText("Вы не выбрали пользователя для удаления!");
            System.out.println("deleteBtn");
        });
    }
    private void initFlightButtons(){
        addNewFlightBtn.setOnAction(Event -> {
            flightWorkingPanel.setVisible(!flightWorkingPanel.isVisible());
            flightOperation = "add";
        });

        flightChangeBtn.setOnAction(Event -> {
            if (pickedFlight != null) {
                flightWorkingPanel.setVisible(!flightWorkingPanel.isVisible());
            } else flightErrorLabel.setText("Вы не выбрали пользователя для изменения!");
            flightOperation = "update";
        });

        flightConfirmBtn.setOnAction(Event -> {
            String startDate = departDateTF.getText().trim();
            String startTime = departTimeTF.getText().trim();
            String startLocation = startLocationTF.getText().trim();
            String landDate = landDateTF.getText().trim();
            String landTime = landTimeTF.getText().trim();
            String landLocation = landLocationTF.getText().trim();
            String startTrack = startTrackTF.getText().trim();

            String plane = "";
            if (planeCB.getSelectionModel().getSelectedItem() != null){
                String[] tempArray = planeCB.getSelectionModel().getSelectedItem().trim().split(":");
                if (tempArray.length > 1){
                    plane = String.valueOf(tempArray[0]);
                }
            }

            if (flightOperation.equals("add")) {
                if (!startLocation.equals("") && !plane.equals("")) {
                    Flight flight = new Flight();
                    flight.setPlane_id(plane);
                    flight.setStart_date(startDate);
                    flight.setStart_time(startTime);
                    flight.setStart_location(startLocation);
                    flight.setLand_date(landDate);
                    flight.setLand_time(landTime);
                    flight.setLand_location(landLocation);
                    flight.setStart_track(startTrack);

                    try {
                        handler.addNewFlight(flight);
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    flightWorkingPanel.setVisible(!flightWorkingPanel.isVisible());
                    disposeFlightData();
                    LoadFlightsData(); //refresh

                } else flightWorkingErrorLabel.setText("Вы не ввели все необходимые данные!");
            } else if (flightOperation.equals("update")){
                if (!startDate.equals("")){
                    pickedFlight.setStart_date(startDate);
                }
                if (!startTime.equals("")){
                    pickedFlight.setStart_time(startTime);
                }
                if (!startLocation.equals("")){
                    pickedFlight.setStart_location(startLocation);
                }
                if (!landDate.equals("")){
                    pickedFlight.setLand_date(landDate);
                }
                if (!landTime.equals("")){
                    pickedFlight.setLand_time(landTime);
                }
                if (!plane.equals("")){
                    pickedFlight.setPlane_id(plane);
                }
                if (!landLocation.equals("")){
                    pickedFlight.setLand_location(landLocation);
                }
                if (!startTrack.equals("")){
                    pickedFlight.setStart_track(startTrack);
                }

                try {
                    handler.updateFlight(pickedFlight);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                flightWorkingPanel.setVisible(!flightWorkingPanel.isVisible());
                disposeFlightData();
                LoadFlightsData();
            }
        });

        flightDeleteBtn.setOnAction(Event -> {
            flightOperation = "delete";
            if (pickedFlight != null){
                try {
                    handler.deleteFlight(pickedFlight.getId());
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                flightErrorLabel.setText("");
                LoadFlightsData();
            } else flightErrorLabel.setText("Вы не выбрали рейс для удаления!");
        });
    }
    private void initPlaneButtons(){
        addNewPlaneBtn.setOnAction(Event -> {
            planeWorkingPanel.setVisible(!planeWorkingPanel.isVisible());
            planeOperation = "add";
        });

        planeChangeBtn.setOnAction(Event -> {
            if (pickedPlane != null) {
                planeWorkingPanel.setVisible(!planeWorkingPanel.isVisible());
            } else planeErrorLabel.setText("Вы не выбрали пользователя для изменения!");
            planeOperation = "update";
        });

        planeConfirmBtn.setOnAction(Event -> {
            String model = modelTF.getText().trim();
            String type = planeTypeTF.getText().trim();
            String capacity = capacityTF.getText().trim();
            String pilotName = pilotNameTF.getText().trim();

            if (planeOperation.equals("add")) {
                if (!pilotName.equals("")) {
                    Plane plane = new Plane();
                    plane.setModel(model);
                    plane.setType(type);
                    plane.setCapacity(capacity);
                    plane.setPilot_name(pilotName);

                    try {
                        handler.addNewPlane(plane);
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                    planeWorkingPanel.setVisible(!planeWorkingPanel.isVisible());
                    disposePlaneData();
                    initFlightPlaneComboBox();
                    LoadPlanesData(); //refresh

                } else planeWorkingErrorLabel.setText("Вы не ввели все необходимые данные!");
            } else if (planeOperation.equals("update")){
                if (!model.equals("")){
                    pickedPlane.setModel(model);
                }
                if (!type.equals("")){
                    pickedPlane.setType(type);
                }
                if (!capacity.equals("")){
                    pickedPlane.setCapacity(capacity);
                }
                if (!pilotName.equals("")){
                    pickedPlane.setPilot_name(pilotName);
                }

                try {
                    handler.updatePlane(pickedPlane);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                initFlightPlaneComboBox();
                planeWorkingPanel.setVisible(!planeWorkingPanel.isVisible());
                disposePlaneData();
                LoadPlanesData();
            }
        });

        planeDeleteBtn.setOnAction(Event -> {
            planeOperation = "delete";
            if (pickedPlane != null){
                try {
                    handler.deletePlane(pickedPlane.getId());
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                planeErrorLabel.setText("");
                LoadPlanesData();
            } else planeErrorLabel.setText("Вы не выбрали самолет для удаления!");
        });
    }

    private void initButtons(){
        initPassengerButtons();
        initFlightButtons();
        initPlaneButtons();
    }
    private void initTables(){
        LoadPassengerTable();
        LoadFlightTable();
        LoadPlaneTable();
    }
    private void disposePassengerData(){
        nameTF.setText("");
        passTF.setText("");
        ageTF.setText("");
        phoneTF.setText("");
        dateOfBirthTF.setText("");
        passengerErrorLabel.setText("");
        passengerWorkingErrorLabel.setText("");
        passengerOperation = "";
    }
    private void disposeFlightData(){
        departDateTF.setText("");
        departTimeTF.setText("");
        startLocationTF.setText("");
        landDateTF.setText("");
        landTimeTF.setText("");
        landLocationTF.setText("");
        startTrackTF.setText("");

        flightErrorLabel.setText("");
        flightWorkingErrorLabel.setText("");
        flightOperation = "";
    }
    private void disposePlaneData(){
        modelTF.setText("");
        planeTypeTF.setText("");
        capacityTF.setText("");
        pilotNameTF.setText("");

        planeOperation = "";
        planeErrorLabel.setText("");
        planeWorkingErrorLabel.setText("");
    }
}