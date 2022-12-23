## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.
## fandefasana an'ilay projet:
run_nena
`Server_Interface_Index` : mandefa ny server principal
`Server_One_Interface`   : mandefa server_repo iray
`Server_Two_Interface`   : mandefa server_repo iray
`Server_Three_Interface` : mandefa server_repo iray
`Clients_Interface`      : mandefa client


## COMMENTAIRE

##                                                                MAIN_SERVER


## Communication rehetra : mandalo avy ao amin'ny `main_server.Main_Server_Tunnel` (Thread anakiray):
    functions :         public void run() -> mamelona ny server ay miandry izay hihiditra aminy
                        void servirConnection(Socket socket) -> manokatra thread anakiray vaovao `Server_Wall` mba ahafan'ny server miresaka 
                                                                @ ilay vao tafiditra

## Communication iray `Server_Wall` iray : ato no tena mandeha ny communication 
 main functions : public void run() -> 1er cas : `server hafa` no mi communique amin'ny ` main_server ` 
                                                rehefa isconnection->false= nideconnecte ilay `server hafa `
                                                de mila esorina ao @ liste ana server connectes `ArrayList ports`
                                    -> 2eme cas : `client` no mi communique  amin'ny ` main_server `
                                                -> soit miteny izy hoe send de mi receive ny ` main_server `
                                                -> soit receive de mi send ny ` main_server `
                                                -> soit get_all_file (tiny ho azo ny fichier misy )
                receive ()          -> partie 1 : maka amn client hoe inona ilay fichier tiny ho alefany
                                                maka anle taille anle fichier_any
                                                tenina aminy hoe tokony ho zarainy firy ilay fichier
                                                alefa any aminy daholo ny port_na server tokony andefasany ilay fichier

                                    -> partie 2 : memorisation an'ilay transfer : anaran'ilay vaovao azo ato amn server sy ny
                                                                                port nandehanany
                                    -> partie 3 : preparation an'ireo server hafa hoe hisy fichier ho tonga ao amin'ny ry zareo

                send ()             -> partie 1 : miteny @ client hoe inona avy no fichier disponible
                                                alaina @ client ilay fichier tiny ho alefa
                                                aveo valiana kely ilay client hoe ity ilay paozin ilay fichier tiny ho azo
                                                aveo amzay tenenina izy hoe raha dispo ilay fichier na tsia
                                                functon is_dispo(disponibles,toSend)        
                                                    dispo raha ao velona daholo ilay server misy azy
                                                    sinon tsy dispo de vita hatreo
                                  -> partie 2 : raha dispo de alaina daholo ilay ports tokony hisy an'ilay fichier
                                                alefa any aminy daholo ny port_na server tokony angalany ilay fichier        
classe hafa : interface : list_client , server_interface_index
              listener  : index_event,list_client event


##                                                        PARTIE CLIENT

## @ alalan'ny `client` no maka na mandefa fichier any amin' ny server 

main function :     void run()      -> rehefa mbola true ny connection de mbola velona ilay client
                                    -> rehetra tsy null ny `task` de zany hoe soit izy lasa en mode reiceve soit en mode send
                                
                sendFile(String m)  ->      miteny @ ilay server ilay anaran'ilay fichier
                                            alefa any amn serveur le taille 
                                            miandry reponse avy aamn serveur hoe tokony tapahana firy le fichier
                                            miandry reponse avy amn serveur hoe aiza avy ny andefasana anle fichier -> port 
                                            manomana `send`  mifanarana @ isan'ny server handefasana :
                                                           ny port ,  fichier , parametre hoe manomboka aiza no alefa le fichier  , 
                                                            tapatapana fichier
                                            start() daholo ilay sernd de tokony mandeha daholo ilay fichier

               receiveFile(String m) ->     miteny @ ilay server hoe inona ilay fichier ho alaina
                                            maka @ server hoe mizara firy no fichier ho azo 
                                            alefa @ izay ny transfer ( ao @ thread receive)
                                            miandry an'izay ho vita
                                            mandeha @ izay ny fanambarana an'ilay fichier mampiasa an'ilay historique.txt 
                                            (misy ny reference(nb) an'ilay  ordre an'ilay fanambarana )
                                            videna avy eo iny historique iny rehefa mitambatra ilay fichier

## @ alalan' ny `Send` no andefasan'ny client fichier @server iray

                    void run()      ->      mi etablier connection amin'ilay server tena angalana an'ilay fichier
                                            tenenina ilay server hoe handefa fichier
                                            tenenina ilay server hoe inona ilay anaranle fichier
                                            mampiasa random access file
                                            specifiena ilay file_pointer hoe manomboka eto no alefa 
                                            initialisation 
                                            transfer
## @ alalan' ny `Recevie` no angalan'ny client fichier @server iray

                    void run()      ->      mi etablier connection amin'ilay server tena angalana an'ilay fichier
                                            tenenina ilay server hoe haka fichier
                                            tenenina ilay server hoe inona ilay anaranle fichier
                                            initialisation 
                                            transfer
classe hafa : interface : Clients_Interface , Form_Connection,Clients_Choice_Interface , List_Files
              listener  : Clients_Interface_event, Form_event,List_Files_Listener



##                              Server_Repo:    SERVEUR HEBERGEUR DE FICHIER

## `server_distributed` no instance an'ny server rehetra izay tsy principal
                    void run()  -> ato no mandeha hoe ny communication rehefa misy te hi communique @ ity server izityany
                                    soit hi_receive izy
                                        -> donc mi_send izany ny server de mamorona Thread Send

                                    soit hi_send izy
                                        -> donc mi_receive izany ny server de mamorona Thread Receive

## `Server_Activity_Status` no ahafahan'ito server ito mi communique @ `main_server` satria ilay communication rehetra tokony mandalo ao daholo
                    void run()  ->  mandefa @ main_server ny momba am'ito server ito (port, ip)
                                    rehefa maty ilay connection de deconnecte @ ilay main_server ity server ity

## `Send` ho an'ny server
                    void run()  ->  maka anle anaranle file alefa
                                    mitady an'ilay fichier ho alaina
                                    tenenina hoe inona ilay anaran'ilay fichier
                                    initialisation
                                    transfer
## `Receive` ho an'ny server
                    void run()  ->  mandray anaran'ily fichier ho azo
                                    preparation an'ilay emplacement an'ilay fichier
                                    initialisation
                                    transfer
classe hafa : interface : Server_One_Interface , Server_Two_Interface,Server_Three_Interface , Form_Connection
              listener  : Server_Connection_Event, Form_event
              server : serverPart1 ,serverPart2 ,serverPart3
