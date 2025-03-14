import os

def add_newlines_to_text_files_recursive(folder_path):
    """
    Goes through a folder and all its subfolders, removes existing newlines around '{' and '}',
    then adds newlines after '{' and '}' in each .json file.

    Args:
        folder_path: The path to the folder containing the .json files.
    """
    try:
        processed_files = 0
        processed_folders = 0
        for root, dirs, files in os.walk(folder_path):
            processed_folders += 1
            print(f"Processing folder: {root}")
            for filename in files:
                if filename.endswith(".json"):
                    file_path = os.path.join(root, filename)
                    try:
                        with open(file_path, 'r', encoding='utf-8') as file:
                            content = file.read()

                        # Remove existing newlines around '{' and '}'
                        content = content.replace('\n',  '')

                        # Add newlines after '{' and '}'
                        modified_content = content.replace('],', '],\n').replace("},", "},\n").replace('",', '",\n')

                        with open(file_path, 'w', encoding='utf-8') as file:
                            file.write(modified_content)
                        print(f"Modified: {file_path}")
                        processed_files += 1
                    except UnicodeDecodeError:
                        print(f"UnicodeDecodeError: Skipping {file_path}. Possible encoding issue.")
                    except Exception as e:
                        print(f"An error occurred with file {file_path}: {e}")

        print(f"Processed {processed_files} files in {processed_folders} folders.")
    except FileNotFoundError:
        print(f"Error: Folder '{folder_path}' not found.")
    except Exception as e:
        print(f"An error occurred: {e}")

# Example usage:
folder_path = "C:\\Users\\matthew.ahwal\\Documents\\capstoneproject-e5-studios\\app\\src\\main\\json"
add_newlines_to_text_files_recursive(folder_path)