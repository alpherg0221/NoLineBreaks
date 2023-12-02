import './App.css'
import {appViewModel} from './AppState.tsx'
import {StackShim} from "@fluentui/react-migration-v8-v9";
import {
  CompoundButton,
  Divider,
  Dropdown,
  Field,
  Option,
  Textarea,
  Toast,
  Toaster,
  ToastTitle,
  useId,
  useToastController
} from "@fluentui/react-components";
import {CopyRegular, OpenRegular} from "@fluentui/react-icons";

function App() {
  const viewModel = appViewModel()

  const toasterId = useId("toaster");
  const {dispatchToast} = useToastController(toasterId);

  const copy = () => {
    viewModel.copy();
    dispatchToast(<Toast><ToastTitle>Copied Formatted Text</ToastTitle></Toast>, {intent: "success"});
  };

  return (
    <div style={{minHeight: "100vh", display: "grid", placeItems: "center", textAlign: "center"}}>
      <Toaster toasterId={toasterId}/>

      <StackShim tokens={{childrenGap: 40}} horizontalAlign="center" verticalAlign="center">
        <StackShim horizontal tokens={{childrenGap: 20}}>
          <Field
            style={{height: "85vh", width: "45vw", maxHeight: "85vh"}}
            validationState={viewModel.text.length <= 5000 ? "success" : "error"}
            validationMessage={`${viewModel.text.length} / 5000`}
          >
            <Textarea
              style={{height: "85vh", width: "45vw"}}
              textarea={{style: {maxHeight: "85vh"}}}
              size="large"
              onChange={(_, data) => {
                viewModel.update({text: data.value})
              }}
            />
          </Field>

          <Field
            style={{height: "85vh", width: "45vw"}}
            validationState={viewModel.formattedText.length <= 5000 ? "success" : "error"}
            validationMessage={`${viewModel.formattedText.length} / 5000`}
          >
            <Textarea
              value={viewModel.formattedText}
              style={{height: "85vh", width: "45vw"}}
              textarea={{style: {maxHeight: "85vh"}}}
              size="large"
              readOnly
            />
          </Field>
        </StackShim>

        <Divider/>

        <StackShim horizontal verticalAlign="center" tokens={{childrenGap: 20}}>
          <CompoundButton
            style={{width: "35vw"}}
            icon={<CopyRegular fontSize={48}/>}
            appearance="subtle"
            onClick={copy}
          >
            Copy Formatted Text
          </CompoundButton>

          <Dropdown
            style={{width: "20vw", height: 40}}
            appearance="outline"
            size="large"
            defaultValue={viewModel.translater}
            value={viewModel.translater}
            onOptionSelect={(_, data) => {
              viewModel.update({translater: data.optionValue})
            }}
          >
            <Option>DeepL</Option>
            <Option>Google</Option>
          </Dropdown>

          <CompoundButton
            style={{width: "35vw"}}
            icon={<OpenRegular fontSize={48}/>}
            appearance="subtle"
            onClick={viewModel.open}
          >
            Open in New Tab
          </CompoundButton>
        </StackShim>
      </StackShim>
    </div>
  )
}

export default App
