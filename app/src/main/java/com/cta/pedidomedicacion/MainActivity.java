package com.cta.pedidomedicacion;
import android.app.*; import android.os.*; import android.content.*; import android.graphics.*; import android.graphics.pdf.PdfDocument; import android.net.Uri;
import androidx.core.content.FileProvider; import android.view.*; import android.widget.*; import android.text.*; import java.text.SimpleDateFormat; import java.util.*;
public class MainActivity extends Activity {
 LinearLayout list; EditText search; ArrayList<Med> meds=new ArrayList<>(); android.content.SharedPreferences prefs; int blue=Color.rgb(13,71,161);
 static class Med{String id,name,unit,section;int min;Med(String n,int m,String u,String s){id=n;name=n;min=m;unit=u;section=s;}}
 public void onCreate(Bundle b){super.onCreate(b);prefs=getSharedPreferences("stock",0);loadData();build();}
 void loadData(){Collections.addAll(meds,
new Med("Furosemida 40 mg", 1, "caja", "Medicación habitual"),
new Med("Gabapentina 100 mg", 2, "cajas", "Medicación habitual"),
new Med("Gabapentina 300 mg", 2, "cajas", "Medicación habitual"),
new Med("Gabapentina 600 mg", 2, "cajas", "Medicación habitual"),
new Med("Haloperidol 2 mg/ml gotas orales", 1, "caja", "Medicación habitual"),
new Med("Hidroxil/Vitagobens", 10, "cajas", "Medicación habitual"),
new Med("Ibuprofeno 600 mg", 3, "cajas", "Medicación habitual"),
new Med("Lactulosa 10 gr sobres", 1, "caja", "Medicación habitual"),
new Med("Levomepromazina 25 mg (Sinogan)", 3, "cajas", "Medicación habitual"),
new Med("Loperamida 2 mg (Fortasec)", 1, "caja", "Medicación habitual"),
new Med("Loratadina 10 mg", 1, "caja", "Medicación habitual"),
new Med("Lorazepam 1 mg", 3, "cajas", "Medicación habitual"),
new Med("Lorazepam 5 mg", 3, "cajas", "Medicación habitual"),
new Med("Lormetazepam 1 mg", 5, "cajas", "Medicación habitual"),
new Med("Lormetazepam 2 mg", 5, "cajas", "Medicación habitual"),
new Med("Metamizol 575 mg", 3, "cajas", "Medicación habitual"),
new Med("Metoclopramida 10 mg", 1, "caja", "Medicación habitual"),
new Med("Midazolam 7,5 mg", 1, "caja", "Medicación habitual"),
new Med("Mirtazapina 15 mg", 1, "caja", "Medicación habitual"),
new Med("Naltrexona 50 mg", 1, "caja", "Medicación habitual"),
new Med("Naproxeno 550 mg", 3, "cajas", "Medicación habitual"),
new Med("Nitroglicerina (Solinitrina) 1 mg/ml", 1, "caja", "Medicación habitual"),
new Med("Olanzapina 2,5 mg", 1, "caja", "Medicación habitual"),
new Med("Olanzapina 5 mg", 2, "cajas", "Medicación habitual"),
new Med("Omeprazol 20 mg", 2, "cajas", "Medicación habitual"),
new Med("Paracetamol 1000 mg", 3, "cajas", "Medicación habitual"),
new Med("Paroxetina 20 mg", 1, "caja", "Medicación habitual"),
new Med("Prednisona 10 mg", 1, "caja", "Medicación habitual"),
new Med("Prednisona 5 mg", 1, "caja", "Medicación habitual"),
new Med("Pregabalina 150 mg", 3, "cajas", "Medicación habitual"),
new Med("Pregabalina 25 mg", 3, "cajas", "Medicación habitual"),
new Med("Pregabalina 50 mg", 3, "cajas", "Medicación habitual"),
new Med("Pregabalina 75 mg", 3, "cajas", "Medicación habitual"),
new Med("Propanolol 40 mg", 1, "caja", "Medicación habitual"),
new Med("Quetiapina 100 mg (Liberación Inmediata)", 1, "caja", "Medicación habitual"),
new Med("Quetiapina 25 mg (Liberación inmediata)", 3, "cajas", "Medicación habitual"),
new Med("Quetiapina 50 mg (Liberación Prolongada)", 1, "caja", "Medicación habitual"),
new Med("Risperidona 1 mg", 1, "caja", "Medicación habitual"),
new Med("Risperidona 3 mg", 1, "caja", "Medicación habitual"),
new Med("Sertralina 100 mg", 1, "caja", "Medicación habitual"),
new Med("Sulpirida 50 mg", 1, "caja", "Medicación habitual"),
new Med("Tiaprida 100 mg", 5, "cajas", "Medicación habitual"),
new Med("Topiramato 25 mg", 1, "caja", "Medicación habitual"),
new Med("Topiramato 100 mg", 1, "caja", "Medicación habitual"),
new Med("Tramadol 50 mg", 1, "caja", "Medicación habitual"),
new Med("Trazodona 100 mg", 3, "cajas", "Medicación habitual"),
new Med("Valproato sódico 500 mg", 1, "caja", "Medicación habitual"),
new Med("Zolpidem 10 mg", 4, "cajas", "Medicación habitual"),
new Med("Zopiclona 7,5 mg", 1, "caja", "Medicación habitual"),
new Med("Acetilcisteína 600 mg", 5, "cajas", "Medicación habitual"),
new Med("Ácido fólico 5 mg", 1, "caja", "Medicación habitual"),
new Med("Almagato (Almax forte) sobres", 1, "caja", "Medicación habitual"),
new Med("Alopurinol 100 mg", 2, "cajas", "Medicación habitual"),
new Med("Alprazolam 2 mg", 1, "caja", "Medicación habitual"),
new Med("Amoxicilina/Clavulánico 875 mg/125 mg", 1, "caja", "Medicación habitual"),
new Med("Aquilea", 1, "caja", "Medicación habitual"),
new Med("Aripiprazol 5 mg (Abilify)", 1, "caja", "Medicación habitual"),
new Med("Betahistina", 1, "caja", "Medicación habitual"),
new Med("Biperideno 2 mg (Akineton)", 1, "caja", "Medicación habitual"),
new Med("Bisoprolol 10 mg", 1, "caja", "Medicación habitual"),
new Med("Bisoprolol 2,5 mg", 1, "caja", "Medicación habitual"),
new Med("Bisoprolol 5 mg", 1, "caja", "Medicación habitual"),
new Med("Bromazepam 1,5 mg", 1, "caja", "Medicación habitual"),
new Med("Buprenorfina 35 mcg/h parches (Transtec)", 1, "caja", "Medicación habitual"),
new Med("Buprenorfina 52,5 mcg/h parche (Transtec)", 1, "caja", "Medicación habitual"),
new Med("Buprenorfina + naloxona (Suboxone) 2 mg/0,5 mg", 5, "cajas", "Medicación habitual"),
new Med("Buprenorfina + naloxona (Zubsolv) 1,4 mg", 3, "cajas", "Medicación habitual"),
new Med("Bupropión 150 mg", 1, "caja", "Medicación habitual"),
new Med("Buscapina 10 mg", 1, "caja", "Medicación habitual"),
new Med("Captopril 25 mg", 1, "caja", "Medicación habitual"),
new Med("Catapresan 0,15 mg", 1, "caja", "Medicación habitual"),
new Med("Cetirizina 10 mg", 1, "caja", "Medicación habitual"),
new Med("Ciclobenzaprina 10 mg", 1, "caja", "Medicación habitual"),
new Med("Ciprofloxacino 500 mg", 1, "caja", "Medicación habitual"),
new Med("Cleboprida/Simeticona 500/200 (Flatoril)", 1, "caja", "Medicación habitual"),
new Med("Clindamicina 300 mg", 1, "caja", "Medicación habitual"),
new Med("Clometiazol", 1, "caja", "Medicación habitual"),
new Med("Clonazepam 0,5 mg (Rivotril)", 2, "cajas", "Medicación habitual"),
new Med("Clonazepam 2 mg (Rivotril)", 2, "cajas", "Medicación habitual"),
new Med("Clorazepato dipotásico 10 mg", 3, "cajas", "Medicación habitual"),
new Med("Clorazepato dipotásico 5 mg", 3, "cajas", "Medicación habitual"),
new Med("Clorpromazina 25 mg", 2, "cajas", "Medicación habitual"),
new Med("Clotiapina 40 mg", 2, "cajas", "Medicación habitual"),
new Med("Codeína 28,7 mg", 1, "caja", "Medicación habitual"),
new Med("Colchicina 0,5 mg", 1, "caja", "Medicación habitual"),
new Med("Couldina", 1, "caja", "Medicación habitual"),
new Med("Dexametasona 4 mg", 1, "caja", "Medicación habitual"),
new Med("Dexclorfeniramina 2 mg (Polaramine)", 2, "cajas", "Medicación habitual"),
new Med("Dexketoprofeno 25 mg", 3, "cajas", "Medicación habitual"),
new Med("Diazepam 10 mg", 5, "cajas", "Medicación habitual"),
new Med("Diazepam 2,5 mg", 5, "cajas", "Medicación habitual"),
new Med("Diazepam 5 mg", 5, "cajas", "Medicación habitual"),
new Med("Diclofenaco 50 mg", 3, "cajas", "Medicación habitual"),
new Med("Disulfiram 250 mg", 2, "cajas", "Medicación habitual"),
new Med("Enalapril 20 mg", 1, "caja", "Medicación habitual"),
new Med("Escitalopram 10 mg", 1, "caja", "Medicación habitual"),
new Med("Fluoxetina 20 mg", 1, "caja", "Medicación habitual"),
new Med("Flurazepam 30 mg", 1, "caja", "Medicación habitual"),
new Med("Fosfomicina 3 g", 2, "cajas", "Medicación habitual"),
new Med("Atropina 1 mg/ml", 3, "ampollas", "Nevera / estantería / mueble"),
new Med("Atrovent 250 mg/2 ml", 1, "caja amp", "Nevera / estantería / mueble"),
new Med("Beclometasona nasal", 1, "spray nasal", "Nevera / estantería / mueble"),
new Med("Betametasona pomada", 1, "tubo", "Nevera / estantería / mueble"),
new Med("Biperideno 5 mg/ml IM (Akineton)", 3, "ampollas", "Nevera / estantería / mueble"),
new Med("Bromuro Ipratropio 250 mg/2 ml (Atrovent)", 2, "caja amp", "Nevera / estantería / mueble"),
new Med("Budesonida 0,25 mg/ml", 1, "caja amp", "Nevera / estantería / mueble"),
new Med("Cetraxal ótico", 1, "frasco", "Nevera / estantería / mueble"),
new Med("Cloperastina fendizoato (Flutox)", 1, "frasco", "Nevera / estantería / mueble"),
new Med("Dexketoprofeno 50 mg/2 ml", 3, "cajas amp", "Nevera / estantería / mueble"),
new Med("Dextrometorfano Hidrobromuro (Cinfatos jarabe)", 1, "frasco", "Nevera / estantería / mueble"),
new Med("Diazepam 10 mg/2 ml", 5, "ampollas", "Nevera / estantería / mueble"),
new Med("Diazepam 5 mg solución rectal", 5, "ampollas", "Nevera / estantería / mueble"),
new Med("Diclofenaco crema", 1, "tubo", "Nevera / estantería / mueble"),
new Med("Haloperidol 5 mg/ml", 3, "ampollas", "Nevera / estantería / mueble"),
new Med("Lidocaína 20 mg/ml", 1, "caja amp", "Nevera / estantería / mueble"),
new Med("Metilprednisolona 40 mg (Urbason)", 3, "ampollas", "Nevera / estantería / mueble"),
new Med("Metoclopramida 10 mg/2 ml", 1, "frasco", "Nevera / estantería / mueble"),
new Med("Micralax 450 mg/45 ml rectal", 12, "ampollas", "Nevera / estantería / mueble"),
new Med("Mupirocina 20 mg/g (Bactroban) pomada", 1, "tubo", "Nevera / estantería / mueble"),
new Med("Naloxona 0,4 mg/ml", 10, "ampollas", "Nevera / estantería / mueble"),
new Med("Piridoxina (Benadón) (Vit B6) 300 mg", 10, "ampollas", "Nevera / estantería / mueble"),
new Med("Risperidona sol. 1 mg/ml frasco 30 ml", 1, "frasco", "Nevera / estantería / mueble"),
new Med("Salbutamol inhalador", 1, "caja amp", "Nevera / estantería / mueble"),
new Med("Silvederma 10 mg/g pomada", 1, "tubo", "Nevera / estantería / mueble"),
new Med("Tiamina (Benerva 10 mg/ml) (Vit B1)", 10, "ampollas", "Nevera / estantería / mueble"),
new Med("Tobrex colirio 3 mg/ml", 1, "frasco", "Nevera / estantería / mueble"));restoreMetadata();}
 TextView tv(String s,int z){TextView t=new TextView(this);t.setText(s);t.setTextSize(z);t.setTextColor(Color.DKGRAY);t.setPadding(14,8,8,8);return t;}
 Button btn(String s){Button b=new Button(this);b.setText(s);return b;}
 void build(){LinearLayout root=new LinearLayout(this);root.setOrientation(LinearLayout.VERTICAL);root.setBackgroundColor(Color.rgb(248,249,250));TextView title=tv("PEDIDO DE MEDICACIÓN",21);title.setTextColor(Color.WHITE);title.setTypeface(null,1);title.setGravity(Gravity.CENTER_VERTICAL);title.setBackgroundColor(blue);root.addView(title,new LinearLayout.LayoutParams(-1,68));LinearLayout bar=new LinearLayout(this);search=new EditText(this);search.setHint("Buscar medicamento...");search.setSingleLine(true);bar.addView(search,new LinearLayout.LayoutParams(0,60,1));Button add=btn("AÑADIR");add.setOnClickListener(v->addMedication());bar.addView(add,new LinearLayout.LayoutParams(-2,60));Button o=btn("REALIZAR PEDIDO");o.setOnClickListener(v->showOrder());bar.addView(o,new LinearLayout.LayoutParams(-2,60));root.addView(bar);list=new LinearLayout(this);list.setOrientation(LinearLayout.VERTICAL);ScrollView sv=new ScrollView(this);sv.addView(list);root.addView(sv,new LinearLayout.LayoutParams(-1,0,1));search.addTextChangedListener(new TextWatcher(){public void beforeTextChanged(CharSequence s,int a,int c,int d){}public void onTextChanged(CharSequence s,int a,int b,int c){render(s.toString());}public void afterTextChanged(Editable e){}});setContentView(root);render("");}
 void render(String q){list.removeAllViews();String last="";for(Med m:meds){if(!q.trim().isEmpty()&&!m.name.toLowerCase(Locale.ROOT).contains(q.toLowerCase(Locale.ROOT)))continue;if(!m.section.equals(last)){TextView h=tv(m.section,18);h.setTextColor(blue);h.setTypeface(null,1);h.setBackgroundColor(Color.rgb(225,235,250));list.addView(h,new LinearLayout.LayoutParams(-1,56));last=m.section;}LinearLayout r=new LinearLayout(this);r.setGravity(Gravity.CENTER_VERTICAL);r.setPadding(6,3,6,3);LinearLayout info=new LinearLayout(this);info.setOrientation(LinearLayout.VERTICAL);TextView n=tv(m.name,16);n.setOnLongClickListener(v->{editMedication(m);return true;});TextView s=tv("Stock mínimo: "+m.min+" "+m.unit,12);s.setTextColor(Color.GRAY);info.addView(n);info.addView(s);r.addView(info,new LinearLayout.LayoutParams(0,68,1));EditText e=new EditText(this);e.setHint("0");e.setInputType(2);e.setText(getQty(m));e.setGravity(Gravity.CENTER);e.setTextSize(18);e.addTextChangedListener(new TextWatcher(){public void beforeTextChanged(CharSequence s,int a,int b,int c){}public void onTextChanged(CharSequence s,int a,int b,int c){prefs.edit().putString("qty_"+m.id,s.toString()).apply();}public void afterTextChanged(Editable e){}});r.addView(e,new LinearLayout.LayoutParams(90,62));list.addView(r);View line=new View(this);line.setBackgroundColor(Color.LTGRAY);list.addView(line,new LinearLayout.LayoutParams(-1,1));}}
 void editMedication(Med m){
  LinearLayout box=new LinearLayout(this);box.setOrientation(LinearLayout.VERTICAL);int pad=24;box.setPadding(pad,0,pad,0);
  EditText name=new EditText(this);name.setSingleLine(true);name.setHint("Nombre del medicamento");name.setText(m.name);
  EditText min=new EditText(this);min.setSingleLine(true);min.setInputType(2);min.setHint("Stock mínimo (número)");min.setText(String.valueOf(m.min));
  EditText unit=new EditText(this);unit.setSingleLine(true);unit.setHint("Unidad (caja, cajas, ampollas...)");unit.setText(m.unit);
  box.addView(name,new LinearLayout.LayoutParams(-1,60));box.addView(min,new LinearLayout.LayoutParams(-1,60));box.addView(unit,new LinearLayout.LayoutParams(-1,60));
  AlertDialog dlg=new AlertDialog.Builder(this).setTitle("Editar medicamento").setMessage("Mantén pulsado el nombre de cualquier medicamento para editarlo.").setView(box).setNegativeButton("CANCELAR",null).setPositiveButton("GUARDAR",null).create();
  dlg.setOnShowListener(x->{dlg.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(v->{
    String oldName=m.name,newName=name.getText().toString().trim(),u=unit.getText().toString().trim();
    int mn;try{mn=Integer.parseInt(min.getText().toString().trim());if(mn<0)throw new Exception();}catch(Exception e){Toast.makeText(this,"El stock mínimo debe ser un número válido",Toast.LENGTH_SHORT).show();return;}
    if(newName.isEmpty()||u.isEmpty()){Toast.makeText(this,"Nombre y unidad son obligatorios",Toast.LENGTH_SHORT).show();return;}
    if(!oldName.equals(newName)){m.name=newName;}
    m.min=mn;m.unit=u;saveMetadata(m);dlg.dismiss();render(search==null?"":search.getText().toString());
  });});dlg.show();
 }
 void addMedication(){
  Med m=new Med("Nuevo medicamento "+UUID.randomUUID(),1,"caja","Medicación habitual");
  LinearLayout box=new LinearLayout(this);box.setOrientation(LinearLayout.VERTICAL);int pad=24;box.setPadding(pad,0,pad,0);
  EditText name=new EditText(this);name.setSingleLine(true);name.setHint("Nombre del medicamento");
  EditText min=new EditText(this);min.setSingleLine(true);min.setInputType(2);min.setHint("Stock mínimo");min.setText("1");
  EditText unit=new EditText(this);unit.setSingleLine(true);unit.setHint("Unidad");unit.setText("caja");
  Spinner section=new Spinner(this);ArrayAdapter<String> a=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,new String[]{"Medicación habitual","Nevera / estantería / mueble"});section.setAdapter(a);
  box.addView(name,new LinearLayout.LayoutParams(-1,60));box.addView(min,new LinearLayout.LayoutParams(-1,60));box.addView(unit,new LinearLayout.LayoutParams(-1,60));box.addView(section,new LinearLayout.LayoutParams(-1,60));
  new AlertDialog.Builder(this).setTitle("Añadir medicamento").setView(box).setNegativeButton("CANCELAR",null).setPositiveButton("AÑADIR",(d,w)->{String n=name.getText().toString().trim(),u=unit.getText().toString().trim();int mn;try{mn=Integer.parseInt(min.getText().toString().trim());}catch(Exception e){mn=-1;}if(n.isEmpty()||u.isEmpty()||mn<0){Toast.makeText(this,"Completa los datos correctamente",Toast.LENGTH_SHORT).show();return;}m.name=n;m.min=mn;m.unit=u;m.section=section.getSelectedItem().toString();meds.add(m);saveMetadata(m);render(search==null?"":search.getText().toString());}).show();
 }
 String getQty(Med m){String v=prefs.getString("qty_"+m.id,null);if(v!=null)return v;return prefs.getString(m.name,"");}
 void saveMetadata(Med m){prefs.edit().putString("meta_"+m.id+"_name",m.name).putInt("meta_"+m.id+"_min",m.min).putString("meta_"+m.id+"_unit",m.unit).putString("meta_"+m.id+"_section",m.section).apply();}
 void restoreMetadata(){for(Med m:meds){String n=prefs.getString("meta_"+m.id+"_name",null);if(n!=null)m.name=n;m.min=prefs.getInt("meta_"+m.id+"_min",m.min);m.unit=prefs.getString("meta_"+m.id+"_unit",m.unit);m.section=prefs.getString("meta_"+m.id+"_section",m.section);}}
 String buildOrder(){String d=new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault()).format(new Date());StringBuilder b=new StringBuilder("PEDIDO DE MEDICACIÓN - ").append(d).append("\n\n");String last="";boolean any=false;for(Med m:meds){int q=0;try{q=Integer.parseInt(getQty(m).trim());}catch(Exception e){}if(q<=0)continue;if(!m.section.equals(last)){b.append(m.section.toUpperCase(Locale.ROOT)).append("\n");last=m.section;}b.append("• ").append(m.name).append(" — ").append(q).append(" ").append(m.unit).append("\n");any=true;}return any?b.toString():"No hay medicación para pedir.";}
 void showOrder(){String text=buildOrder();AlertDialog d=new AlertDialog.Builder(this).setTitle("Pedido generado").setMessage(text).setPositiveButton("COPIAR",(x,w)->{android.content.ClipboardManager cm=(android.content.ClipboardManager)getSystemService(CLIPBOARD_SERVICE);cm.setPrimaryClip(android.content.ClipData.newPlainText("Pedido",text));Toast.makeText(this,"Pedido copiado",Toast.LENGTH_SHORT).show();}).setNegativeButton("PDF",null).setNeutralButton("COMPARTIR",null).create();d.setOnShowListener(x->{d.getButton(-2).setOnClickListener(v->makePdf(text));d.getButton(-3).setOnClickListener(v->{Intent i=new Intent(Intent.ACTION_SEND);i.setType("text/plain");i.putExtra(Intent.EXTRA_TEXT,text);startActivity(Intent.createChooser(i,"Compartir pedido"));});});d.show();}
 void makePdf(String text){try{PdfDocument doc=new PdfDocument();int pageNo=1;PdfDocument.Page p=doc.startPage(new PdfDocument.PageInfo.Builder(595,842,pageNo).create());Canvas c=p.getCanvas();Paint paint=new Paint();paint.setColor(Color.BLACK);paint.setTextSize(12);float y=45;for(String line:text.split("\n")){if(y>800){doc.finishPage(p);pageNo++;p=doc.startPage(new PdfDocument.PageInfo.Builder(595,842,pageNo).create());c=p.getCanvas();y=45;}c.drawText(line,35,y,paint);y+=20;}doc.finishPage(p);java.io.File f=new java.io.File(getExternalFilesDir(null),"pedido_medicacion_"+new SimpleDateFormat("yyyyMMdd_HHmm",Locale.getDefault()).format(new Date())+".pdf");java.io.FileOutputStream out=new java.io.FileOutputStream(f);doc.writeTo(out);out.close();doc.close();Toast.makeText(this,"PDF creado: "+f.getName(),Toast.LENGTH_LONG).show();Intent i=new Intent(Intent.ACTION_SEND);i.setType("application/pdf");i.putExtra(Intent.EXTRA_STREAM,FileProvider.getUriForFile(this,"com.cta.pedidomedicacion.fileprovider",f));i.putExtra(Intent.EXTRA_TEXT,text);try{startActivity(Intent.createChooser(i,"Compartir PDF"));}catch(Exception e){}}catch(Exception e){Toast.makeText(this,"Error creando PDF: "+e.getMessage(),Toast.LENGTH_LONG).show();}}
}
