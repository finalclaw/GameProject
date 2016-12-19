package test;

import org.newdawn.slick.*;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tiled.TiledMap;

public class Play extends BasicGameState {
	private TiledMap map = null;
	public int[] beatsCurrent;
	Image chara;
	Image green;
	Image test;
	int cX = 256;
	int cY = 256;
	public boolean start = false;
	public boolean oneTime;
	public Sound sound;
	public boolean timerGoing = false;
	public boolean musicStart = true;
	public long sysTime;
	public double currentTime;
	public double beatTimer;
	public boolean isInput;
	public boolean inputOnce = true;
	public Music m;
	int beats = -1;
	double shortTime;
	int l = 5;
	public double beatRange;
	boolean lives = true;
	int bCounter = 0;
	boolean stop;
	UnicodeFont Necro;
	double different;
	boolean firstInput = false;
	public int[] beatsZone1_1 = {522,1043,1565,2087,2609,3130,3652,4174,4696,5217,5739,6261,6783,7304,7826,8348,8870,9391,9913,10435,10957,11478,12000,12522,13043,13565,14087,14609,15130,15652,16174,16696,17217,17739,18261,18783,19304,19826,20348,20870,21391,21913,22435,22957,23478,24000,24522,25043,25565,26087,26609,27130,27652,28174,28696,29217,29739,30261,30783,31304,31826,32348,32870,33391,33913,34435,34957,35478,36000,36522,37043,37565,38087,38609,39130,39652,40174,40696,41217,41739,42261,42783,43304,43826,44348,44870,45391,45913,46435,46957,47478,48000,48522,49043,49565,50087,50609,51130,51652,52174,52696,53217,53739,54261,54783,55304,55826,56348,56870,57391,57913,58435,58957,59478,60000,60522,61043,61565,62087,62609,63130,63652,64174,64696,65217,65739,66261,66783,67304,67826,68348,68870,69391,69913,70435,70957,71478,72000,72522,73043,73565,74087,74609,75130,75652,76174,76696,77217,77739,78261,78783,79304,79826,80348,80870,81391,81913,82435,82957,83478,84000,84522,85043,85565,86087,86609,87130,87652,88174,88696,89217,89739,90261,90783,91304,91826,92348,92870,93391,93913,94435,94957,95478,96000,96522,97043,97565,98087,98609,99130,99652,100174,100696,101217,101739,102261,102783,103304,103826,104348,104870,105391,105913,106435,106957,107478,108000,108522,109043,109565,110087,110609,111130,111652,112174,112696,113217,113739,114261,114783,115304,115826,116348,116870,117391,117913,118435,118957,119478,120000,120522,121043,121565,122087,122609,123130,123652,124174,124696,125217,125739,126261,126783,127304,127826,128348,128870,129391,129913,130435,130957,131478,132000,132522,133043,133565,134087,134609,135130,135652,136174,136696,137217,137739,138261,138783,139304,139826,140348,140870,141391,141913,142435,142957,143478,144000,144522,145043,145565,146087,146609,147130,147652,148174,148696,149217,149739,150261,150783,151304,151826,152348,152870,153391,153913,154435,154957,155478,156000,156522,157043,157565,158087,158609,159130,159652,160174,160696,161217,161739,162261,162783,163304,163826,164348,164870,165391,165913,166435,166957,167478,168000,168522,169043,169565,170087,170609,171130,171652,172174,172696,173217,173739,174261,174783,175304};
	public int[] beatsZone1_2 = {474,935,1397,1858,2320,2781,3243,3704,4166,4627,5089,5550,6012,6474,6935,7397,7858,8320,8781,9243,9704,10166,10627,11089,11550,12012,12474,12935,13397,13858,14320,14781,15243,15704,16166,16627,17089,17550,18012,18474,18935,19397,19858,20320,20781,21243,21704,22166,22627,23089,23550,24012,24474,24935,25397,25858,26320,26781,27243,27704,28166,28627,29089,29550,30012,30474,30935,31397,31858,32320,32781,33243,33704,34166,34627,35089,35550,36012,36474,36935,37397,37858,38320,38781,39243,39704,40166,40627,41089,41550,42012,42474,42935,43397,43858,44320,44781,45243,45704,46166,46627,47089,47550,48012,48474,48935,49397,49858,50320,50781,51243,51704,52166,52627,53089,53550,54012,54474,54935,55397,55858,56320,56781,57243,57704,58166,58627,59089,59550,60012,60474,60935,61397,61858,62320,62781,63243,63704,64166,64627,65089,65550,66012,66474,66935,67397,67858,68320,68781,69243,69704,70166,70627,71089,71550,72012,72474,72935,73397,73858,74320,74781,75243,75704,76166,76627,77089,77550,78012,78474,78935,79397,79858,80320,80781,81243,81704,82166,82627,83089,83550,84012,84474,84935,85397,85858,86320,86781,87243,87704,88166,88627,89089,89550,90012,90474,90935,91397,91858,92320,92781,93243,93704,94166,94627,95089,95550,96012,96474,96935,97397,97858,98320,98781,99243,99704,100166,100627,101089,101550,102012,102474,102935,103397,103858,104320,104781,105243,105704,106166,106627,107089,107550,108012,108474,108935,109397,109858,110320,110781,111243,111704,112166,112627,113089,113550,114012,114474,114935,115397,115858,116320,116781,117243,117704,118166,118627,119089,119550,120012,120474,120935,121397,121858,122320,122781,123243,123704,124166,124627,125089,125550,126012,126474,126935,127397,127858,128320,128781,129243,129704,130166,130627,131089,131550,132012,132474,132935,133397,133858,134320,134781,135243,135704,136166,136627,137089,137550,138012,138474,138935,139397,139858,140320,140781,141243,141704,142166,142627,143089,143550,144012,144474,144935,145397,145858,146320,146781,147243,147704,148166,148627,149089,149550,150012,150474,150935,151397,151858,152320,152781,153243,153704,154166,154627,155089,155550,156012,156474,156935,157397,157858,158320,158781,159243,159704,160166,160627,161089};
	public int[] beatsZone1_3 = {454,882,1311,1739,2168,2596,3025,3454,3882,4311,4739,5168,5596,6025,6454,6882,7311,7739,8168,8596,9025,9454,9882,10311,10739,11168,11596,12025,12454,12882,13311,13739,14168,14596,15025,15454,15882,16311,16739,17168,17596,18025,18454,18882,19311,19739,20168,20596,21025,21454,21882,22311,22739,23168,23596,24025,24454,24882,25311,25739,26168,26596,27025,27454,27882,28311,28739,29168,29596,30025,30454,30882,31311,31739,32168,32596,33025,33454,33882,34311,34739,35168,35596,36025,36454,36882,37311,37739,38168,38596,39025,39454,39882,40311,40739,41168,41596,42025,42454,42882,43311,43739,44168,44596,45025,45454,45882,46311,46739,47168,47596,48025,48454,48882,49311,49739,50168,50596,51025,51454,51882,52311,52739,53168,53596,54025,54454,54882,55311,55739,56168,56596,57025,57454,57882,58311,58739,59168,59596,60025,60454,60882,61311,61739,62168,62596,63025,63454,63882,64311,64739,65168,65596,66025,66454,66882,67311,67739,68168,68596,69025,69454,69882,70311,70739,71168,71596,72025,72454,72882,73311,73739,74168,74596,75025,75454,75882,76311,76739,77168,77596,78025,78454,78882,79311,79739,80168,80596,81025,81454,81882,82311,82739,83168,83596,84025,84454,84882,85311,85739,86168,86596,87025,87454,87882,88311,88739,89168,89596,90025,90454,90882,91311,91739,92168,92596,93025,93454,93882,94311,94739,95168,95596,96025,96454,96882,97311,97739,98168,98596,99025,99454,99882,100311,100739,101168,101596,102025,102454,102882,103311,103739,104168,104596,105025,105454,105882,106311,106739,107168,107596,108025,108454,108882,109311,109739,110168,110596,111025,111454,111882,112311,112739,113168,113596,114025,114454,114882,115311,115739,116168,116596,117025,117454,117882,118311,118739,119168,119596,120025,120454,120882,121311,121739,122168,122596,123025,123454,123882,124311,124739,125168,125596,126025,126454,126882,127311,127739,128168,128596,129025,129454,129882,130311,130739,131168,131596,132025,132454,132882,133311,133739,134168,134596,135025,135454,135882,136311,136739,137168,137596,138025,138454,138882,139311,139739,140168,140596,141025,141454,141882,142311,142739,143168,143596,144025,144454,144882,145311,145739,146168,146596,147025,147454,147882,148311,148739,149168,149596,150025,150454,150882,151311,151739,152168,152596,153025,153454,153882,154311,154739,155168,155596,156025,156454,156882,157311,157739,158168,158596,159025,159454,159882,160311,160739,161168,161596,162025,162454,162882,163311,163739,164168,164596,165025,165454,165882,166311,166739,167168,167596,168025,168454,168882,169311,169739,170168,170596,171025,171454,171882,172311,172739};
	public int[] beatsZone2_1 = {462,923,1385,1846,2308,2769,3231,3692,4154,4615,5077,5538,6000,6462,6923,7385,7846,8308,8769,9231,9692,10154,10615,11077,11538,12000,12462,12923,13385,13846,14308,14769,15231,15692,16154,16615,17077,17538,18000,18462,18923,19385,19846,20308,20769,21231,21692,22154,22615,23077,23538,24000,24462,24923,25385,25846,26308,26769,27231,27692,28154,28615,29077,29538,30000,30462,30923,31385,31846,32308,32769,33231,33692,34154,34615,35077,35538,36000,36462,36923,37385,37846,38308,38769,39231,39692,40154,40615,41077,41538,42000,42462,42923,43385,43846,44308,44769,45231,45692,46154,46615,47077,47538,48000,48462,48923,49385,49846,50308,50769,51231,51692,52154,52615,53077,53538,54000,54462,54923,55385,55846,56308,56769,57231,57692,58154,58615,59077,59538,60000,60462,60923,61385,61846,62308,62769,63231,63692,64154,64615,65077,65538,66000,66462,66923,67385,67846,68308,68769,69231,69692,70154,70615,71077,71538,72000,72462,72923,73385,73846,74308,74769,75231,75692,76154,76615,77077,77538,78000,78462,78923,79385,79846,80308,80769,81231,81692,82154,82615,83077,83538,84000,84462,84923,85385,85846,86308,86769,87231,87692,88154,88615,89077,89538,90000,90462,90923,91385,91846,92308,92769,93231,93692,94154,94615,95077,95538,96000,96462,96923,97385,97846,98308,98769,99231,99692,100154,100615,101077,101538,102000,102462,102923,103385,103846,104308,104769,105231,105692,106154,106615,107077,107538,108000,108462,108923,109385,109846,110308,110769,111231,111692,112154,112615,113077,113538,114000,114462,114923,115385,115846,116308,116769,117231,117692,118154,118615,119077,119538,120000,120462,120923,121385,121846,122308,122769,123231,123692,124154,124615,125077,125538,126000,126462,126923,127385,127846,128308,128769,129231,129692,130154,130615,131077,131538,132000,132462,132923,133385,133846,134308,134769,135231,135692,136154,136615,137077,137538,138000,138462,138923,139385,139846,140308,140769,141231,141692,142154,142615,143077,143538,144000,144462,144923,145385,145846,146308,146769,147231,147692,148154,148615,149077,149538,150000,150462,150923,151385,151846,152308,152769,153231,153692,154154,154615,155077};
	public int[] beatsZone2_2 = {429,857,1286,1714,2143,2571,3000,3429,3857,4286,4714,5143,5571,6000,6429,6857,7286,7714,8143,8571,9000,9429,9857,10286,10714,11143,11571,12000,12429,12857,13286,13714,14143,14571,15000,15429,15857,16286,16714,17143,17571,18000,18429,18857,19286,19714,20143,20571,21000,21429,21857,22286,22714,23143,23571,24000,24429,24857,25286,25714,26143,26571,27000,27429,27857,28286,28714,29143,29571,30000,30429,30857,31286,31714,32143,32571,33000,33429,33857,34286,34714,35143,35571,36000,36429,36857,37286,37714,38143,38571,39000,39429,39857,40286,40714,41143,41571,42000,42429,42857,43286,43714,44143,44571,45000,45429,45857,46286,46714,47143,47571,48000,48429,48857,49286,49714,50143,50571,51000,51429,51857,52286,52714,53143,53571,54000,54429,54857,55286,55714,56143,56571,57000,57429,57857,58286,58714,59143,59571,60000,60429,60857,61286,61714,62143,62571,63000,63429,63857,64286,64714,65143,65571,66000,66429,66857,67286,67714,68143,68571,69000,69429,69857,70286,70714,71143,71571,72000,72429,72857,73286,73714,74143,74571,75000,75429,75857,76286,76714,77143,77571,78000,78429,78857,79286,79714,80143,80571,81000,81429,81857,82286,82714,83143,83571,84000,84429,84857,85286,85714,86143,86571,87000,87429,87857,88286,88714,89143,89571,90000,90429,90857,91286,91714,92143,92571,93000,93429,93857,94286,94714,95143,95571,96000,96429,96857,97286,97714,98143,98571,99000,99429,99857,100286,100714,101143,101571,102000,102429,102857,103286,103714,104143,104571,105000,105429,105857,106286,106714,107143,107571,108000,108429,108857,109286,109714,110143,110571,111000,111429,111857,112286,112714,113143,113571,114000,114429,114857,115286,115714,116143,116571,117000,117429,117857,118286,118714,119143,119571,120000,120429,120857,121286,121714,122143,122571,123000,123429,123857,124286,124714,125143,125571,126000,126429,126857,127286,127714,128143,128571,129000,129429,129857,130286,130714,131143,131571,132000,132429,132857,133286,133714,134143,134571,135000,135429,135857,136286,136714,137143,137571,138000,138429,138857,139286,139714,140143,140571,141000,141429,141857,142286,142714,143143,143571,144000,144429,144857,145286,145714,146143,146571,147000,147429,147857,148286,148714,149143,149571,150000,150429,150857,151286,151714,152143,152571,153000,153429,153857,154286,154714,155143,155571,156000,156429,156857,157286,157714,158143,158571,159000,159429,159857,160286,160714,161143,161571,162000,162429,162857,163286,163714,164143,164572};
	public int[] beatsZone2_3 = {400,800,1200,1600,2000,2400,2800,3200,3600,4000,4400,4800,5200,5600,6000,6400,6800,7200,7600,8000,8400,8800,9200,9600,10000,10400,10800,11200,11600,12000,12400,12800,13200,13600,14000,14400,14800,15200,15600,16000,16400,16800,17200,17600,18000,18400,18800,19200,19600,20000,20400,20800,21200,21600,22000,22400,22800,23200,23600,24000,24400,24800,25200,25600,26000,26400,26800,27200,27600,28000,28400,28800,29200,29600,30000,30400,30800,31200,31600,32000,32400,32800,33200,33600,34000,34400,34800,35200,35600,36000,36400,36800,37200,37600,38000,38400,38800,39200,39600,40000,40400,40800,41200,41600,42000,42400,42800,43200,43600,44000,44400,44800,45200,45600,46000,46400,46800,47200,47600,48000,48400,48800,49200,49600,50000,50400,50800,51200,51600,52000,52400,52800,53200,53600,54000,54400,54800,55200,55600,56000,56400,56800,57200,57600,58000,58400,58800,59200,59600,60000,60400,60800,61200,61600,62000,62400,62800,63200,63600,64000,64400,64800,65200,65600,66000,66400,66800,67200,67600,68000,68400,68800,69200,69600,70000,70400,70800,71200,71600,72000,72400,72800,73200,73600,74000,74400,74800,75200,75600,76000,76400,76800,77200,77600,78000,78400,78800,79200,79600,80000,80400,80800,81200,81600,82000,82400,82800,83200,83600,84000,84400,84800,85200,85600,86000,86400,86800,87200,87600,88000,88400,88800,89200,89600,90000,90400,90800,91200,91600,92000,92400,92800,93200,93600,94000,94400,94800,95200,95600,96000,96400,96800,97200,97600,98000,98400,98800,99200,99600,100000,100400,100800,101200,101600,102000,102400,102800,103200,103600,104000,104400,104800,105200,105600,106000,106400,106800,107200,107600,108000,108400,108800,109200,109600,110000,110400,110800,111200,111600,112000,112400,112800,113200,113600,114000,114400,114800,115200,115600,116000,116400,116800,117200,117600,118000,118400,118800,119200,119600,120000,120400,120800,121200,121600,122000,122400,122800,123200,123600,124000,124400,124800,125200,125600,126000,126400,126800,127200,127600,128000,128400,128800,129200,129600,130000,130400,130800,131200,131600,132000,132400,132800,133200,133600,134000,134400,134800,135200,135600,136000,136400,136800,137200,137600,138000,138400,138800,139200,139600,140000,140400,140800,141200,141600,142000,142400,142800,143200,143600,144000,144400,144800,145200,145600,146000,146400,146800,147200,147600,148000,148400,148800,149200,149600,150000,150400,150800,151200,151600,152000,152400,152800,153200,153600,154000,154400,154800,155200,155600,156000,156400,156800,157200,157600,158000,158400,158800,159200,159600,160000,160400,160800,161200,161600,162000,162400,162800,163200,163600,164000,164400,164800,165200,165600,166000,166400};
	public int[] beatsZone3_1 = {444,889,1333,1778,2222,2667,3111,3556,4000,4444,4889,5333,5778,6222,6667,7111,7556,8000,8444,8889,9333,9778,10222,10667,11111,11556,12000,12444,12889,13333,13778,14222,14667,15111,15556,16000,16444,16889,17333,17778,18222,18667,19111,19556,20000,20444,20889,21333,21778,22222,22667,23111,23556,24000,24444,24889,25333,25778,26222,26667,27111,27556,28000,28444,28889,29333,29778,30222,30667,31111,31556,32000,32444,32889,33333,33778,34222,34667,35111,35556,36000,36444,36889,37333,37778,38222,38667,39111,39556,40000,40444,40889,41333,41778,42222,42667,43111,43556,44000,44444,44889,45333,45778,46222,46667,47111,47556,48000,48444,48889,49333,49778,50222,50667,51111,51556,52000,52444,52889,53333,53778,54222,54667,55111,55556,56000,56444,56889,57333,57778,58222,58667,59111,59556,60000,60444,60889,61333,61778,62222,62667,63111,63556,64000,64444,64889,65333,65778,66222,66667,67111,67556,68000,68444,68889,69333,69778,70222,70667,71111,71556,72000,72444,72889,73333,73778,74222,74667,75111,75556,76000,76444,76889,77333,77778,78222,78667,79111,79556,80000,80444,80889,81333,81778,82222,82667,83111,83556,84000,84444,84889,85333,85778,86222,86667,87111,87556,88000,88444,88889,89333,89778,90222,90667,91111,91556,92000,92444,92889,93333,93778,94222,94667,95111,95556,96000,96444,96889,97333,97778,98222,98667,99111,99556,100000,100444,100889,101333,101778,102222,102667,103111,103556,104000,104444,104889,105333,105778,106222,106667,107111,107556,108000,108444,108889,109333,109778,110222,110667,111111,111556,112000,112444,112889,113333,113778,114222,114667,115111,115556,116000,116444,116889,117333,117778,118222,118667,119111,119556,120000,120444,120889,121333,121778,122222,122667,123111,123556,124000,124444,124889,125333,125778,126222,126667,127111,127556,128000,128444,128889,129333,129778,130222,130667,131111,131556,132000,132444,132889,133333,133778,134222,134667,135111,135556,136000,136444,136889,137333,137778,138222,138667,139111,139556,140000,140444,140889,141333,141778,142222,142667,143111,143556,144000,144444,144889,145333,145778,146222,146667,147111,147556,148000,148444,148889,149333,149778,150222,150667,151111,151556,152000,152444,152889,153333,153778,154222,154667,155111,155556,156000,156444,156889,157333,157778,158222,158667,159111,159556,160000};
	public int[] beatsZone3_2 = {414,828,1241,1655,2069,2483,2897,3310,3724,4138,4552,4966,5379,5793,6207,6621,7034,7448,7862,8276,8690,9103,9517,9931,10345,10759,11172,11586,12000,12414,12828,13241,13655,14069,14483,14897,15310,15724,16138,16552,16966,17379,17793,18207,18621,19034,19448,19862,20276,20690,21103,21517,21931,22345,22759,23172,23586,24000,24414,24828,25241,25655,26069,26483,26897,27310,27724,28138,28552,28966,29379,29793,30207,30621,31034,31448,31862,32276,32690,33103,33517,33931,34345,34759,35172,35586,36000,36414,36828,37241,37655,38069,38483,38897,39310,39724,40138,40552,40966,41379,41793,42207,42621,43034,43448,43862,44276,44690,45103,45517,45931,46345,46759,47172,47586,48000,48414,48828,49241,49655,50069,50483,50897,51310,51724,52138,52552,52966,53379,53793,54207,54621,55034,55448,55862,56276,56690,57103,57517,57931,58345,58759,59172,59586,60000,60414,60828,61241,61655,62069,62483,62897,63310,63724,64138,64552,64966,65379,65793,66207,66621,67034,67448,67862,68276,68690,69103,69517,69931,70345,70759,71172,71586,72000,72414,72828,73241,73655,74069,74483,74897,75310,75724,76138,76552,76966,77379,77793,78207,78621,79034,79448,79862,80276,80690,81103,81517,81931,82345,82759,83172,83586,84000,84414,84828,85241,85655,86069,86483,86897,87310,87724,88138,88552,88966,89379,89793,90207,90621,91034,91448,91862,92276,92690,93103,93517,93931,94345,94759,95172,95586,96000,96414,96828,97241,97655,98069,98483,98897,99310,99724,100138,100552,100966,101379,101793,102207,102621,103034,103448,103862,104276,104690,105103,105517,105931,106345,106759,107172,107586,108000,108414,108828,109241,109655,110069,110483,110897,111310,111724,112138,112552,112966,113379,113793,114207,114621,115034,115448,115862,116276,116690,117103,117517,117931,118345,118759,119172,119586,120000,120414,120828,121241,121655,122069,122483,122897,123310,123724,124138,124552,124966,125379,125793,126207,126621,127034,127448,127862,128276,128690,129103,129517,129931,130345,130759,131172,131586,132000,132414,132828,133241,133655,134069,134483,134897,135310,135724,136138,136552,136966,137379,137793,138207,138621,139034,139448,139862,140276,140690,141103,141517,141931,142345,142759,143172,143586,144000,144414,144828,145241,145655,146069,146483,146897,147310,147724,148138,148552,148966,149379,149793,150207,150621,151034,151448,151862,152276,152690,153103,153517,153931,154345,154759,155172,155586,156000,156414,156828,157241,157655,158069,158483,158897,159310,159724,160138,160552,160966,161379,161793,162207};
	public int[] beatsZone3_3 = {387,774,1161,1548,1935,2323,2710,3097,3484,3871,4258,4645,5032,5419,5806,6194,6581,6968,7355,7742,8129,8516,8903,9290,9677,10065,10452,10839,11226,11613,12000,12387,12774,13161,13548,13935,14323,14710,15097,15484,15871,16258,16645,17032,17419,17806,18194,18581,18968,19355,19742,20129,20516,20903,21290,21677,22065,22452,22839,23226,23613,24000,24387,24774,25161,25548,25935,26323,26710,27097,27484,27871,28258,28645,29032,29419,29806,30194,30581,30968,31355,31742,32129,32516,32903,33290,33677,34065,34452,34839,35226,35613,36000,36387,36774,37161,37548,37935,38323,38710,39097,39484,39871,40258,40645,41032,41419,41806,42194,42581,42968,43355,43742,44129,44516,44903,45290,45677,46065,46452,46839,47226,47613,48000,48387,48774,49161,49548,49935,50323,50710,51097,51484,51871,52258,52645,53032,53419,53806,54194,54581,54968,55355,55742,56129,56516,56903,57290,57677,58065,58452,58839,59226,59613,60000,60387,60774,61161,61548,61935,62323,62710,63097,63484,63871,64258,64645,65032,65419,65806,66194,66581,66968,67355,67742,68129,68516,68903,69290,69677,70065,70452,70839,71226,71613,72000,72387,72774,73161,73548,73935,74323,74710,75097,75484,75871,76258,76645,77032,77419,77806,78194,78581,78968,79355,79742,80129,80516,80903,81290,81677,82065,82452,82839,83226,83613,84000,84387,84774,85161,85548,85935,86323,86710,87097,87484,87871,88258,88645,89032,89419,89806,90194,90581,90968,91355,91742,92129,92516,92903,93290,93677,94065,94452,94839,95226,95613,96000,96387,96774,97161,97548,97935,98323,98710,99097,99484,99871,100258,100645,101032,101419,101806,102194,102581,102968,103355,103742,104129,104516,104903,105290,105677,106065,106452,106839,107226,107613,108000,108387,108774,109161,109548,109935,110323,110710,111097,111484,111871,112258,112645,113032,113419,113806,114194,114581,114968,115355,115742,116129,116516,116903,117290,117677,118065,118452,118839,119226,119613,120000,120387,120774,121161,121548,121935,122323,122710,123097,123484,123871,124258,124645,125032,125419,125806,126194,126581,126968,127355,127742,128129,128516,128903,129290,129677,130065,130452,130839,131226,131613,132000,132387,132774,133161,133548,133935,134323,134710,135097,135484,135871,136258,136645,137032,137419,137806,138194,138581,138968,139355,139742,140129,140516,140903,141290,141677,142065,142452,142839,143226,143613,144000,144387,144774,145161,145548,145935,146323,146710,147097,147484,147871,148258,148645,149032,149419,149806,150194,150581,150968,151355,151742,152129,152516,152903,153290,153677,154065,154452,154839,155226,155613,156000,156387,156774,157161,157548,157935,158323,158710,159097,159484,159871,160258,160645,161032,161419,161806,162194,162581,162968,163355,163742,164129,164516,164903,165290,165677,166065,166452,166839,167226,167613,168000,168387,168774,169161,169548,169935,170323,170710,171097,171484,171871,172258,172645,173032,173419,173806};
	public int[] beatsZone4_1 = {462,923,1385,1846,2308,2769,3231,3692,4154,4615,5077,5538,6000,6462,6923,7385,7846,8308,8769,9231,9692,10154,10615,11077,11538,12000,12462,12923,13385,13846,14308,14769,15231,15692,16154,16615,17077,17538,18000,18462,18923,19385,19846,20308,20769,21231,21692,22154,22615,23077,23538,24000,24462,24923,25385,25846,26308,26769,27231,27692,28154,28615,29077,29538,30000,30462,30923,31385,31846,32308,32769,33231,33692,34154,34615,35077,35538,36000,36462,36923,37385,37846,38308,38769,39231,39692,40154,40615,41077,41538,42000,42462,42923,43385,43846,44308,44769,45231,45692,46154,46615,47077,47538,48000,48462,48923,49385,49846,50308,50769,51231,51692,52154,52615,53077,53538,54000,54462,54923,55385,55846,56308,56769,57231,57692,58154,58615,59077,59538,60000,60462,60923,61385,61846,62308,62769,63231,63692,64154,64615,65077,65538,66000,66462,66923,67385,67846,68308,68769,69231,69692,70154,70615,71077,71538,72000,72462,72923,73385,73846,74308,74769,75231,75692,76154,76615,77077,77538,78000,78462,78923,79385,79846,80308,80769,81231,81692,82154,82615,83077,83538,84000,84462,84923,85385,85846,86308,86769,87231,87692,88154,88615,89077,89538,90000,90462,90923,91385,91846,92308,92769,93231,93692,94154,94615,95077,95538,96000,96462,96923,97385,97846,98308,98769,99231,99692,100154,100615,101077,101538,102000,102462,102923,103385,103846,104308,104769,105231,105692,106154,106615,107077,107538,108000,108462,108923,109385,109846,110308,110769,111231,111692,112154,112615,113077,113538,114000,114462,114923,115385,115846,116308,116769,117231,117692,118154,118615,119077,119538,120000,120462,120923,121385,121846,122308,122769,123231,123692,124154,124615,125077,125538,126000,126462,126923,127385,127846,128308,128769,129231,129692,130154,130615,131077,131538,132000,132462,132923,133385,133846,134308,134769,135231,135692,136154,136615,137077,137538,138000,138462,138923,139385,139846,140308,140769,141231,141692,142154,142615,143077,143538,144000,144462,144923,145385,145846,146308,146769,147231,147692,148154,148615,149077,149538,150000,150462,150923,151385,151846,152308,152769,153231,153692,154154,154615,155077,155538,156000,156462,156923,157385,157846,158308,158769,159231,159692,160154,160615,161077,161538,162000,162462,162923,163385,163846,164308,164769,165231,165692,166154,166615,167077,167538,168000,168462,168923,169385,169846,170308,170769,171231,171692,172154,172615,173077,173538,174000,174462,174923,175385,175846,176308,176769,177231,177692,178154,178615};
	public int[] beatsZone4_2 = {414,828,1241,1655,2069,2483,2897,3310,3724,4138,4552,4966,5379,5793,6207,6621,7034,7448,7862,8276,8690,9103,9517,9931,10345,10759,11172,11586,12000,12414,12828,13241,13655,14069,14483,14897,15310,15724,16138,16552,16966,17379,17793,18207,18621,19034,19448,19862,20276,20690,21103,21517,21931,22345,22759,23172,23586,24000,24414,24828,25241,25655,26069,26483,26897,27310,27724,28138,28552,28966,29379,29793,30207,30621,31034,31448,31862,32276,32690,33103,33517,33931,34345,34759,35172,35586,36000,36414,36828,37241,37655,38069,38483,38897,39310,39724,40138,40552,40966,41379,41793,42207,42621,43034,43448,43862,44276,44690,45103,45517,45931,46345,46759,47172,47586,48000,48414,48828,49241,49655,50069,50483,50897,51310,51724,52138,52552,52966,53379,53793,54207,54621,55034,55448,55862,56276,56690,57103,57517,57931,58345,58759,59172,59586,60000,60414,60828,61241,61655,62069,62483,62897,63310,63724,64138,64552,64966,65379,65793,66207,66621,67034,67448,67862,68276,68690,69103,69517,69931,70345,70759,71172,71586,72000,72414,72828,73241,73655,74069,74483,74897,75310,75724,76138,76552,76966,77379,77793,78207,78621,79034,79448,79862,80276,80690,81103,81517,81931,82345,82759,83172,83586,84000,84414,84828,85241,85655,86069,86483,86897,87310,87724,88138,88552,88966,89379,89793,90207,90621,91034,91448,91862,92276,92690,93103,93517,93931,94345,94759,95172,95586,96000,96414,96828,97241,97655,98069,98483,98897,99310,99724,100138,100552,100966,101379,101793,102207,102621,103034,103448,103862,104276,104690,105103,105517,105931,106345,106759,107172,107586,108000,108414,108828,109241,109655,110069,110483,110897,111310,111724,112138,112552,112966,113379,113793,114207,114621,115034,115448,115862,116276,116690,117103,117517,117931,118345,118759,119172,119586,120000,120414,120828,121241,121655,122069,122483,122897,123310,123724,124138,124552,124966,125379,125793,126207,126621,127034,127448,127862,128276,128690,129103,129517,129931,130345,130759,131172,131586,132000,132414,132828,133241,133655,134069,134483,134897,135310,135724,136138,136552,136966,137379,137793,138207,138621,139034,139448,139862,140276,140690,141103,141517,141931,142345,142759,143172,143586,144000,144414,144828,145241,145655,146069,146483,146897,147310,147724,148138,148552,148966,149379,149793,150207,150621,151034,151448,151862,152276,152690,153103,153517,153931,154345,154759,155172,155586,156000,156414,156828,157241,157655,158069};
	public int[] beatsZone4_3 = {375,750,1125,1500,1875,2250,2625,3000,3375,3750,4125,4500,4875,5250,5625,6000,6375,6750,7125,7500,7875,8250,8625,9000,9375,9750,10125,10500,10875,11250,11625,12000,12375,12750,13125,13500,13875,14250,14625,15000,15375,15750,16125,16500,16875,17250,17625,18000,18375,18750,19125,19500,19875,20250,20625,21000,21375,21750,22125,22500,22875,23250,23625,24000,24375,24750,25125,25500,25875,26250,26625,27000,27375,27750,28125,28500,28875,29250,29625,30000,30375,30750,31125,31500,31875,32250,32625,33000,33375,33750,34125,34500,34875,35250,35625,36000,36375,36750,37125,37500,37875,38250,38625,39000,39375,39750,40125,40500,40875,41250,41625,42000,42375,42750,43125,43500,43875,44250,44625,45000,45375,45750,46125,46500,46875,47250,47625,48000,48375,48750,49125,49500,49875,50250,50625,51000,51375,51750,52125,52500,52875,53250,53625,54000,54375,54750,55125,55500,55875,56250,56625,57000,57375,57750,58125,58500,58875,59250,59625,60000,60375,60750,61125,61500,61875,62250,62625,63000,63375,63750,64125,64500,64875,65250,65625,66000,66375,66750,67125,67500,67875,68250,68625,69000,69375,69750,70125,70500,70875,71250,71625,72000,72375,72750,73125,73500,73875,74250,74625,75000,75375,75750,76125,76500,76875,77250,77625,78000,78375,78750,79125,79500,79875,80250,80625,81000,81375,81750,82125,82500,82875,83250,83625,84000,84375,84750,85125,85500,85875,86250,86625,87000,87375,87750,88125,88500,88875,89250,89625,90000,90375,90750,91125,91500,91875,92250,92625,93000,93375,93750,94125,94500,94875,95250,95625,96000,96375,96750,97125,97500,97875,98250,98625,99000,99375,99750,100125,100500,100875,101250,101625,102000,102375,102750,103125,103500,103875,104250,104625,105000,105375,105750,106125,106500,106875,107250,107625,108000,108375,108750,109125,109500,109875,110250,110625,111000,111375,111750,112125,112500,112875,113250,113625,114000,114375,114750,115125,115500,115875,116250,116625,117000,117375,117750,118125,118500,118875,119250,119625,120000,120375,120750,121125,121500,121875,122250,122625,123000,123375,123750,124125,124500,124875,125250,125625,126000,126375,126750,127125,127500,127875,128250,128625,129000,129375,129750,130125,130500,130875,131250,131625,132000,132375,132750,133125,133500,133875,134250,134625,135000,135375,135750,136125,136500,136875,137250,137625,138000,138375,138750,139125,139500,139875,140250,140625,141000,141375,141750,142125,142500,142875,143250,143625,144000,144375,144750,145125,145500,145875,146250,146625,147000,147375,147750,148125,148500,148875,149250,149625,150000,150375,150750,151125,151500,151875,152250,152625,153000,153375,153750,154125,154500,154875,155250,155625,156000,156375,156750,157125};
	public int[] beatsLobby = {450,912,1373,1835,2296,2758,3219,3681,4142,4604,5065,5527,5988,6450,6912,7373,7835,8296,8758,9219,9681,10142,10604,11065,11527,11988,12450,12912,13373,13835,14296,14758,15219,15681,16142,16604,17065,17527,17988,18450,18912,19373,19835,20296,20758,21219,21681,22142,22604,23065,23527,23988,24450,24912,25373,25835,26296,26758,27219,27681,28142,28604,29065,29527,29988,30450,30912,31373,31835,32296,32758,33219,33681,34142,34604,35065,35527,35988,36450,36912,37373,37835,38296,38758,39219,39681,40142,40604,41065,41527,41988,42450,42912,43373,43835,44296,44758,45219,45681,46142,46604,47065,47527,47988,48450,48912,49373,49835,50296,50758,51219,51681,52142,52604,53065,53527,53988,54450,54912,55373,55835,56296,56758,57219,57681,58142,58604,59065,59527,59988,60450,60912,61373,61835,62296,62758,63219,63681,64142,64604,65065,65527,65988};
	public int[] beatsChess = {488,976,1463,1951,2439,2927,3415,3902,4390,4878,5366,5854,6341,6829,7317,7805,8293,8780,9268,9756,10244,10732,11220,11707,12195,12683,13171,13659,14146,14634,15122,15610,16098,16585,17073,17561,18049,18537,19024,19512,20000,20488,20976,21463,21951,22439,22927,23415,23902,24390,24878,25366,25854,26341,26829,27317,27805,28293,28780,29268,29756,30244,30732,31220,31707,32195,32683,33171,33659,34146,34634,35122,35610,36098,36585,37073,37561,38049,38537};
	public int[] beatsMetal = {343,686,1029,1371,1714,2057,2400,2743,3086,3429,3771,4114,4457,4800,5143,5486,5829,6171,6514,6857,7200,7543,7886,8229,8571,8914,9257,9600,9943,10286,10629,10971,11314,11657,12000,12343,12686,13029,13371,13714,14057,14400,14743,15086,15429,15771,16114,16457,16800,17143,17486,17829,18171,18514,18857,19200,19543,19886,20229,20571,20914,21257,21600,21943,22286,22629,22971,23314,23657,24000,24343,24686,25029,25371,25714,26057,26400,26743,27086,27429,27771,28114,28457,28800,29143,29486,29829,30171,30514,30857,31200,31543,31886,32229,32571,32914,33257,33600,33943,34286,34629,34971,35314,35657,36000,36343,36686,37029,37371,37714,38057,38400,38743,39086,39429,39771,40114,40457,40800,41143,41486,41829,42171,42514,42857,43200,43543,43886,44229,44571,44914,45257,45600,45943,46286,46629,46971,47314,47657,48000,48343,48686,49029,49371,49714,50057,50400,50743,51086,51429,51771,52114,52457,52800,53143,53486,53829,54171,54514,54857,55200,55543,55886,56229,56571,56914,57257,57600,57943,58286,58629,58971,59314,59657,60000};
	public int[][] beatsList = {beatsZone1_1,beatsZone1_2,beatsZone1_3,beatsZone2_1,beatsZone2_2,beatsZone2_3,beatsZone3_1,beatsZone3_1,beatsZone3_2,beatsZone3_2,beatsZone3_3,beatsZone3_3,beatsZone4_1,beatsZone4_2,beatsZone4_3,beatsLobby,beatsChess,beatsMetal};
	@SuppressWarnings("unchecked")
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		map = new TiledMap("res/test.tmx","res");
		chara = new Image("res/chara.png");
//		m = music[0];
		String fontPath = "res/Necro.ttf";
		Necro = new UnicodeFont(fontPath, 20, true, false);
		Necro.addAsciiGlyphs();
		Necro.addGlyphs(400, 600);
		Necro.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
		Necro.loadGlyphs();
		green = new Image("res/ha.png");
		test = new Image("res/char.png");
	}



	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		map.render(0,0);
		if (isInput && timerGoing){
			g.drawImage(green,120,0);
			g.drawImage(green,cX,cY);
		} else if(timerGoing) {
		g.drawImage(chara,cX,cY);
		}
		if (l >= 5) {
			g.drawImage(chara, 64*7, 64*11);
		}
		if (l >= 4) {
			g.drawImage(chara, 64*11, 64*11);
		}
		if (l >= 3) {
			g.drawImage(chara, 64*5, 64*11);
		}
		if (l >= 2) {
			g.drawImage(chara, 64*13, 64*11);
		}
		if (l >= 1) {
			g.drawImage(chara, 64*9, 64*11);
		}
		g.setFont(Necro);
		g.drawString("Beats : " + beats, 184, 12);
		g.drawString("Lives : " + l, 184, 32);
		g.drawString("Counter : " + different, 184, 52);
//		g.drawString("beatsCurrent : " + beatsCurrent[bCounter], 184, 72);
		g.drawString("isInput : " + isInput, 184, 92);
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		if(musicStart){
			m = Menu.getSong();
			beatsCurrent = beatsList[Menu.getBeats()];
			beatRange = beatsCurrent[0] / 3.25;
			m.play();
			timerGoing = true;
			musicStart = false;
			sysTime = System.nanoTime();
			}
		if(timerGoing){
			
			currentTime = (double) ((System.nanoTime() - sysTime)/1000000.0);
			different = currentTime;
			if (l==-1){
//				gc.exit();
			}
				if(different <= beatsCurrent[bCounter] + beatRange && different >= beatsCurrent[bCounter] - beatRange && beats >= 0){
					isInput = true;
					oneTime = false;
					start = true;
					if(stop){
						lives = false;
						stop = false;
						}
					} else if(beats > -1){
								if(!oneTime){
									bCounter++;
									oneTime = true;
								}
							inputOnce = true;
							isInput = false;
							stop = true;
							if(!lives && firstInput){
								lives = true;
								l=l-1;
							}
					}
				if(different >= beatsCurrent[beats+1] - 10){
					beats++;

					isInput = true;
					}
				
		}
		
			Input input = gc.getInput();
		
		if(input.isKeyPressed(Input.KEY_W)&& beats > 0) {
			if(inputOnce){
				inputOnce = false;
				if(isInput){
					lives = true;
					firstInput = true;
					if(cY > 64*1){
						cY = cY - 64;
					}
							}
			}
		}
		if(input.isKeyPressed(Input.KEY_S)) {
			if(inputOnce){
				inputOnce = false;
				if(isInput){
					lives = true;
					firstInput = true;
					if(cY < 64*10){
						cY = cY + 64;
					}
							}
			}

		}
		if(input.isKeyPressed(Input.KEY_A)) {
			if(inputOnce){
				inputOnce = false;
				if(isInput){
					lives = true;
					firstInput = true;
					if(cX > 64*2){
						cX = cX - 64;
					}
							}
			}
		}
		if(input.isKeyPressed(Input.KEY_D)) {
			if(inputOnce){
				inputOnce = false;
				if(isInput){
					lives = true;
					firstInput = true;
					if(cX < 64*16){
						cX = cX + 64;
					}
							}
			}

		}
		if(input.isKeyPressed(Input.KEY_Q)){
			gc.exit();
		}
		if(input.isKeyPressed(Input.KEY_ESCAPE)){
			sbg.enterState(0);
			m.stop();
			start = false;
			timerGoing = false;
			musicStart = true;
			inputOnce = true;
			l = 5;
			bCounter = 0;
			beats = -1;
			cX = 256;
			cY = 256;
			firstInput = false;
			isInput = false;
		}
		
	}

	public int getID() {
		return 1;
	}
}